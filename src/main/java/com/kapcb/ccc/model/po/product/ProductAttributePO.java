package com.kapcb.ccc.model.po.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title: ProductAttributePO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductAttributePO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/5 22:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributePO implements Serializable {

    private static final long serialVersionUID = -9089915967781366346L;

    /**
     * 商品属性id
     */
    private Long attributeId;

    /**
     * 商品类目l3
     */
    private Long categoryId;

    /**
     * 商品属性名称
     */
    private String attributeName;

    /**
     * 商品属性选择类型: 0->唯一; 1->单选; 2->多选;
     */
    private Integer selectType;

    /**
     * 属性录入方式: 0->人工手动录入; 1->从列表中选取录入;
     */
    private Integer inputType;

    /**
     *
     */
    private Integer inputList;

    /**
     * 分类筛选样式: 1->普通; 2->颜色;
     */
    private Integer filterType;

    /**
     * 检索类型: 0->不需要检索; 1->关键字检索; 2->范围检索;
     */
    private Integer searchType;

    /**
     * 相同属性商品是否进行关联: 0->不关联; 1->关联;
     */
    private Integer relateStatus;

    /**
     * 自定义添加状态: 0->允许自定义添加; 1->不允许自定义添加
     */
    private Integer customAddStatus;

    /**
     * 商品属性类型: 0->规格; 1->参数;
     */
    private Integer attributeType;

    /**
     * 商品排序, 最高的排序可以单独上传图片
     */
    private Integer sort;

    /**
     * 创建用户id
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新用户id
     */
    private Long lastUpdateBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 逻辑删除
     */
    private Integer deleteStatus;

}
