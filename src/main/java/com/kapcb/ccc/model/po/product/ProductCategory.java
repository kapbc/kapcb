package com.kapcb.ccc.model.po.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductCategory </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductCategory <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 12:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 5925355844590539865L;

    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    @TableField("parent_id")
    private Integer parentId;

    @TableField("category_level")
    private Integer categoryLevel;

    @TableField("category_name")
    private String categoryName;

    @TableLogic
    @TableField("delete_flag")
    private Integer deleteStatus;

    /**
     * 是否显示: 0->不显示; 1->显示;
     */
    private Integer showStatus;

    /**
     * 展示图标
     */
    private String showIcon;

    /**
     * 产品数量
     */
    private Integer productCount;

    /**
     * 数量单位
     */
    private String productUnit;

    @Version
    @TableField("version")
    private Integer version;

    @TableField("create_date")
    private Date createDate;

    @TableField("create_by")
    private Long createBy;

    @TableField("last_update_date")
    private Date lastUpdateDate;

    @TableField("last_update_by")
    private Long lastUpdateBy;
}
