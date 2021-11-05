package com.kapcb.ccc.model.po.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
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
@TableName("product_grp.product_category")
public class ProductCategoryPO implements Serializable {

    private static final long serialVersionUID = -3823181862793064458L;

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
    private Boolean deleteFlag;

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
