package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.kapcb.ccc.enums.IntegerPool;
import com.kapcb.ccc.enums.LongPool;
import com.kapcb.ccc.mapper.ProductCategoryMapper;
import com.kapcb.ccc.model.bo.ProductCategoryBO;
import com.kapcb.ccc.model.initial.CategoryAnalyzeDTO;
import com.kapcb.ccc.model.po.product.ProductCategoryPO;
import com.kapcb.ccc.service.ICategoryService;
import com.kapcb.ccc.utils.InitialDataAnalyzeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
        categoryAnalyzeDTOS = InitialDataAnalyzeUtil.analyzeProductCategory();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
                    ProductCategoryPO existCategory = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, productCategoryPO.getCategoryName()).eq(ProductCategoryPO::getCategoryLevel, 1));
                    if (Objects.isNull(existCategory)) {
                        this.baseMapper.insert(productCategoryPO);
                    }
                    log.info("insert l1 category id is : {}, category zh is : {}", productCategoryPO.getCategoryId(), productCategoryPO.getCategoryName());
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
                        ProductCategoryPO productCategoryPO = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, categoryL1).eq(ProductCategoryPO::getCategoryLevel, 1));
                        ProductCategoryPO existCategory = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, key).eq(ProductCategoryPO::getCategoryLevel, 2));

                        if (Objects.nonNull(productCategoryPO) && !StringUtils.equalsAnyIgnoreCase(productCategoryPO.getCategoryName(), key) && Objects.isNull(existCategory)) {
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
    @Transactional(rollbackFor = Exception.class)
    public Boolean analyzeCategoryL3() {
        if (CollectionUtils.isNotEmpty(categoryAnalyzeDTOS)) {
            Date currentDate = new Date();
            for (CategoryAnalyzeDTO categoryAnalyzeDTO : categoryAnalyzeDTOS) {
                String categoryL2 = categoryAnalyzeDTO.getCategoryL2();
                ProductCategoryPO productCategoryPOl1 = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, categoryL2).eq(ProductCategoryPO::getCategoryLevel, 1));
                ProductCategoryPO productCategoryPOl2 = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, categoryL2).eq(ProductCategoryPO::getCategoryLevel, 2));
                ProductCategoryPO productCategoryPOl3 = this.baseMapper.selectOne(new LambdaQueryWrapper<ProductCategoryPO>().eq(ProductCategoryPO::getCategoryName, categoryL2).eq(ProductCategoryPO::getCategoryLevel, 3));
                if (Objects.nonNull(productCategoryPOl2) && Objects.isNull(productCategoryPOl3) && Objects.isNull(productCategoryPOl1) &&
                        !StringUtils.equalsAnyIgnoreCase(productCategoryPOl2.getCategoryName(), categoryAnalyzeDTO.getCategoryL3())) {
                    this.baseMapper.insert(ProductCategoryPO.builder()
                            .parentId(productCategoryPOl2.getCategoryId())
                            .categoryName(categoryAnalyzeDTO.getCategoryL3())
                            .categoryLevel(3)
                            .createBy(LongPool.DEFAULT_SUPER_ADMIN.value())
                            .createDate(currentDate).build());
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public List<ProductCategoryBO> handlerCategory() {
        List<ProductCategoryBO> productCategoryBOList = this.baseMapper.getProductCategory();
        List<ProductCategoryBO> categoryL1List = productCategoryBOList.parallelStream().filter(productCategory -> IntegerPool.ONE.value().equals(productCategory.getCategoryLevel())).distinct().collect(Collectors.toList());
        List<List<ProductCategoryBO>> partition = Lists.partition(categoryL1List, 2);
        List<ProductCategoryBO> result = new ArrayList<>();

        long currentTimeMillis = System.currentTimeMillis();
        CompletableFuture.allOf(partition.stream().map(sub -> CompletableFuture.supplyAsync(() -> {
            sub.forEach(parent -> parent = handlerTortoise(parent, productCategoryBOList));
            return sub;
        }).whenCompleteAsync((r, e) -> result.addAll(r)).exceptionally(e -> {
            log.error("async product category error, error message is : {}", e.getMessage());
            return result;
        })).toArray(CompletableFuture[]::new)).join();


//        categoryL1List.forEach(parent -> parent = handlerTortoise(parent, productCategoryBOList));
        log.info("cost time is : {} ms", (System.currentTimeMillis() - currentTimeMillis));
        return result;
    }

    private static ProductCategoryBO handlerTortoise(@NonNull ProductCategoryBO parent, List<ProductCategoryBO> list) {
        list.forEach(child -> {
            if (Objects.equals(parent.getCategoryId(), child.getParentId())) {
                parent.getChildren().add(handlerTortoise(child, list));
            }
        });
        return parent;
    }
}
