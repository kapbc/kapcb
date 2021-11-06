package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <a>Title: ProductMemberPricePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductMemberPricePO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 12:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductMemberPricePO implements Serializable {

    private static final long serialVersionUID = -8762141827553956474L;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 会员等级
     */
    private Integer memberLevel;

    /**
     * 会员价格
     */
    private BigDecimal memberPrice;

    /**
     * 会员等级名称
     */
    private String memberLevelName;
}
