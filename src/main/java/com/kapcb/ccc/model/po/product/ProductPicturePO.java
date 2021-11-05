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

    private Long pictureId;

    private Long productId;

    private String fileUrl;

    private String fileName;

    private Integer fileSize;

    private Integer fileType;

    private Long createBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;
}
