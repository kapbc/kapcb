package com.kapcb.ccc.controller;

import com.kapcb.ccc.model.bo.ProductCategoryBO;
import com.kapcb.ccc.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <a>Title: CategoryController </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CategoryController <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/16 15:11
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController {

    private final ICategoryService categoryService;

//    @GetMapping("l1")
//    public String analyzeCategoryL1() {
//        return categoryService.analyzeCategoryL1() ? "success" : "fail";
//    }
//
//    @GetMapping("l2")
//    public String analyzeCategoryL2() {
//        return categoryService.analyzeCategoryL2() ? "success" : "fail";
//    }
//
//    @GetMapping("l3")
//    public String analyzeCategoryL3() {
//        return categoryService.analyzeCategoryL3() ? "success" : "fail";
//    }

    @GetMapping("test")
    public List<ProductCategoryBO> handlerCategory() {
        return categoryService.handlerCategory();
    }
}
