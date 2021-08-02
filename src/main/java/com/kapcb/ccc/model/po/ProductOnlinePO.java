package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <a>Title: ProductPO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 22:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductOnlinePO {

    private Long productId;

    private Long storeId;

    private String productName;

    private Long categoryL4;

    private String productDescription;

    private String modelNumber;

    private BigDecimal productPrice;

    private Date createDate;

    private Long createBy;

    private Date lastUpdateDate;

    private Long lastUpdateBy;

    private Integer version;

    private Boolean deleteFlag;
}
