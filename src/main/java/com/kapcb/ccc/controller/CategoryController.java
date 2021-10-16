package com.kapcb.ccc.controller;

import com.kapcb.ccc.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("test")
    public String analyzeCategory() {
        return categoryService.analyzeCategory() ? "success" : "fail";
    }
}
