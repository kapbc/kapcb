package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.mapper.ProductCategoryMapper;
import com.kapcb.ccc.model.initial.CategoryAnalyzeDTO;
import com.kapcb.ccc.model.po.ProductCategoryPO;
import com.kapcb.ccc.service.ICategoryService;
import com.kapcb.ccc.utils.ProductCategoryAnalyzeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public Boolean analyzeCategory() {
        List<CategoryAnalyzeDTO> categoryAnalyzeDTOS = ProductCategoryAnalyzeUtil.analyzeProductCategory();
        if (CollectionUtils.isNotEmpty(categoryAnalyzeDTOS)) {
            Date currentDate = new Date();
//            categoryAnalyzeDTOS.stream().map(analyze -> ProductCategoryPO.builder()
//                    .parentCategoryId()
//                    .categoryLevel()
//                    .categoryNameEn()
//                    .categoryNameZh()
//                    .deleteFlag(Boolean.FALSE)
//                    .createDate(currentDate)
//                    .createBy(LongPool.DEFAULT_SUPER_ADMIN.value()).build());

        }
        return null;
    }

}
