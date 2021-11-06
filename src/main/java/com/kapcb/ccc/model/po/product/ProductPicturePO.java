package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductPicturePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductPicturePO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPicturePO implements Serializable {

    private static final long serialVersionUID = -546313197832829335L;

    /**
     * 自增主键id
     */
    private Long pictureId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * url地址
     */
    private String fileUrl;

    /**
     * 名称
     */
    private String fileName;

    /**
     * 大小
     */
    private Integer fileSize;

    /**
     * 是否是主图片或视频: 0->不是; 1->是;
     */
    private Integer primaryStatus;

    /**
     * 文件类型: 1->图片; 2->文件; 3->视频;
     */
    private Integer fileType;

    /**
     * 创建用户id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新用户
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;
}
