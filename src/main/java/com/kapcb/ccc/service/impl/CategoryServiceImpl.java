package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.enums.LongPool;
import com.kapcb.ccc.mapper.ProductCategoryMapper;
import com.kapcb.ccc.model.initial.CategoryAnalyzeDTO;
import com.kapcb.ccc.model.po.ProductCategoryPO;
import com.kapcb.ccc.service.ICategoryService;
import com.kapcb.ccc.utils.ProductCategoryAnalyzeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <a>Title: CategoryServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CategoryServiceImpl <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/16 15:12
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategoryPO> implements ICategoryService {

    private static List<CategoryAnalyzeDTO> categoryAnalyzeDTOS;

    @PostConstruct
    void init() {
        categoryAnalyzeDTOS = ProductCategoryAnalyzeUtil.analyzeProductCategory();
    }

    @Override
    public Boolean analyzeCategoryL1() {
        if (CollectionUtils.isNotEmpty(categoryAnalyzeDTOS)) {
            Date currentDate = new Date();
            CompletableFuture<Map<String, List<CategoryAnalyzeDTO>>> categoryL1CompletableFuture = CompletableFuture.supplyAsync(() -> categoryAnalyzeDTOS.parallelStream().collect(Collectors.groupingBy(CategoryAnalyzeDTO::getCategoryL1)));
            CompletableFuture.allOf(categoryL1CompletableFuture).join();
            Map<String, List<CategoryAnalyzeDTO>> categoryL1 = null;
            try {
                categoryL1 = categoryL1CompletableFuture.get();
            } catch (Exception e) {
                log.error("category completable error, error message is : {}", e.getMessage());
            }
            Assert.notNull(categoryL1, "category l1 can not be null");
            Set<String> l1 = categoryL1.keySet();

            List<ProductCategoryPO> l1Date = l1.stream().map(analyze -> CompletableFuture.supplyAsync(() -> ProductCategoryPO.builder()
                    .categoryLevel(1)
                    .parentId(0)
                    .categoryName(analyze)
                    .deleteFlag(Boolean.FALSE)
                    .createDate(currentDate)
                    .createBy(LongPool.DEFAULT_SUPER_ADMIN.value()).build())).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());

            log.info("l1 data is : {}", l1Date);
            if (CollectionUtils.isNotEmpty(l1Date)) {
                for (ProductCategoryPO productCategoryPO : l1Date) {
                    this.baseMapper.insert(productCategoryPO);
                    log.info("insert l1 category id is : {}, category zh is : {}", productCategoryPO.getCategoryId(), productCategoryPO.getCategoryName());
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean analyzeCategoryL2() {
        if (CollectionUtils.isNotEmpty(categoryAnalyzeDTOS)) {
            Date currentDate = new Date();
            CompletableFuture<Map<String, List<CategoryAnalyzeDTO>>> categoryL2CompletableFuture = CompletableFuture.supplyAsync(() -> categoryAnalyzeDTOS.parallelStream().collect(Collectors.groupingBy(CategoryAnalyzeDTO::getCategoryL2)));
            CompletableFuture.allOf(categoryL2CompletableFuture).join();

            Map<String, List<CategoryAnalyzeDTO>> categoryL2 = null;
            try {
                categoryL2 = categoryL2CompletableFuture.get();
            } catch (Exception e) {
                log.error("category completable error, error message is : {}", e.getMessage());
            }
            Set<Map.Entry<String, List<CategoryAnalyzeDTO>>> entries = categoryL2.entrySet();
            for (Map.Entry<String, List<CategoryAnalyzeDTO>> entry : entries) {
                String key = entry.getKey();
                List<CategoryAnalyzeDTO> value = entry.getValue();
                if (CollectionUtils.isNotEmpty(value)) {
                    CategoryAnalyzeDTO categoryAnalyzeDTO = value.get(0);
                    String categoryL1 = categoryAnalyzeDTO.getCategoryL1();
                    if (StringUtils.isNotBlank(categoryL1)) {
                        ProductCategoryPO productCategoryPO = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, categoryL1));
                        if (Objects.nonNull(productCategoryPO)) {
                            this.baseMapper.insert(ProductCategoryPO.builder()
                                    .parentId(productCategoryPO.getCategoryId())
                                    .categoryName(key)
                                    .categoryLevel(2)
                                    .createBy(LongPool.DEFAULT_SUPER_ADMIN.value())
                                    .createDate(currentDate).build());
                        }
                    }
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean analyzeCategoryL3() {
        if (CollectionUtils.isNotEmpty(categoryAnalyzeDTOS)) {
            for (CategoryAnalyzeDTO categoryAnalyzeDTO : categoryAnalyzeDTOS) {
                String categoryL2 = categoryAnalyzeDTO.getCategoryL2();
                ProductCategoryPO productCategoryPO = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, categoryL2));

            }
        }
        return null;
    }
}
