package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.bo.ProductCategoryBO;
import com.kapcb.ccc.model.po.ProductCategoryPO;

import java.util.List;

/**
 * <a>Title: ICategoryService </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ICategoryService <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/16 15:13
 */
public interface ICategoryService extends IService<ProductCategoryPO> {
    Boolean analyzeCategoryL1();

    Boolean analyzeCategoryL2();

    Boolean analyzeCategoryL3();

    List<ProductCategoryBO> handlerCategory();

}
