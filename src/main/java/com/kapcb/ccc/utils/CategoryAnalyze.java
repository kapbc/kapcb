package com.kapcb.ccc.utils;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <a>Title: CategoryAnalyze </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CategoryAnalyze <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/2 13:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAnalyze {

    @ExcelProperty(value = {"category_l3"}, index = 0)
    private String categoryL3;

    @ExcelProperty(value = {"category_l2"}, index = 1)
    private String categoryL2;

    @ExcelProperty(value = {"category_l1"}, index = 2)
    private String categoryL1;


}
