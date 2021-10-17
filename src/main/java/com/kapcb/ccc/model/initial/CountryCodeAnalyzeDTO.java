package com.kapcb.ccc.model.initial;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <a>Title: I18nAnalyzeDTO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: I18nAnalyzeDTO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/7 23:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryCodeAnalyzeDTO {

    @ExcelProperty(index = 0)
    private String CN;

    @ExcelProperty(index = 1)
    private String EN;

    @ExcelProperty(index = 2)
    private String description;

    @ExcelProperty(index = 3)
    private String codeTwo;

    @ExcelProperty(index = 4)
    private String codeThree;

    @ExcelProperty(index = 5)
    private String number;

    @ExcelProperty(index = 6)
    private String remark;
}
