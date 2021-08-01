package com.kapcb.ccc.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductImagePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/1 22:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductImagePO implements Serializable {

    private static final long serialVersionUID = -2140832050075497867L;

    /**
     * 产品图片id
     */
    private Long productImageId;

    /**
     * 产品图片地址
     */
    private String productImageUrl;

    /**
     * 图片大小
     */
    private String imageSize;

    /**
     * 是否是主图
     */
    private Boolean mainImage;

    /**
     * 显示顺序
     */
    private Integer displaySequence;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 逻辑删除
     */
    private Boolean deleteFlag;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新时间
     */
    private Long lastUpdateBy;

    /**
     * 最后更新人
     */
    private Date lastUpdateDate;
}
