package com.kapcb.ccc.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: ProductCategoryAnalyzeUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/9/25 21:27
 */
@Slf4j
@UtilityClass
public class ProductCategoryAnalyzeUtil {

    public static List<CategoryAnalyze> analyzeProductCategory() {
        List<CategoryAnalyze> productCategoryList = new ArrayList<>();
        try (InputStream inputStream = Files.newInputStream(Paths.get("src/main/resources/doc/product_category.xlsx"))) {
            EasyExcel.read(inputStream, CategoryAnalyze.class, new PageRead
        productCategoryList.forEach(System.out::println);
        return productCategoryList;
    }

    public static void main(String[] args) {

        List<CategoryAnalyze> strings = analyzeProductCategory();
    }

}
