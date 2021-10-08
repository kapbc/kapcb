package com.kapcb.ccc.model.initial;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class I18nAnalyzeDTO implements Serializable {

    private static final long serialVersionUID = -639179619373322146L;

    @ExcelProperty(index = 0)
    private Integer id;

    @ExcelProperty(index = 1)
    private String CN;

    @ExcelProperty(index = 2)
    private String EN;

    @ExcelProperty(index = 3)
    private String description;

    @ExcelProperty(index = 4)
    private String codeTwo;

    @ExcelProperty(index = 5)
    private String codeThree;

    @ExcelProperty(index = 6)
    private String number;

    @ExcelProperty(index = 7)
    private String remark;

}
