package com.kapcb.ccc.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.kapcb.ccc.model.initial.CategoryAnalyzeDTO;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.InputStream;
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

    public static List<CategoryAnalyzeDTO> analyzeProductCategory() {
        String fileName = FileUtil.getPath() + "doc/product_category.xlsx";

        CategoryAnalyzeListener testDataListener = new CategoryAnalyzeListener();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (Exception e) {
            log.error("exception message is : {}", e.getMessage());
        }
        ExcelReader build = EasyExcelFactory.read(inputStream, CategoryAnalyzeDTO.class, testDataListener).headRowNumber(1).build();
        build.readAll();
        build.finish();
        List<CategoryAnalyzeDTO> result = testDataListener.getResult();
        return null;
    }

    public static void main(String[] args) {
        List<CategoryAnalyzeDTO> strings = analyzeProductCategory();
    }
}
