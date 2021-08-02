package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductCategoryPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 23:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductCategoryPO implements Serializable {

    private static final long serialVersionUID = -3823181862793064458L;

    private Integer categoryId;

    private Integer parentCategoryId;

    private Integer categoryLevel;

    private String categoryNameEn;

    private String categoryNameZh;

    private Boolean deleteFlag;

    private Integer version;

    private Date createDate;

    private Long createBy;

    private Date lastUpdateDate;

    private Long lastUpdateBy;
}
