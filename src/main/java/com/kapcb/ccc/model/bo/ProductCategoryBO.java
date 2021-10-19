package com.kapcb.ccc.model.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: ProductCategoryBO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProductCategoryBO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/16 22:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductCategoryBO {

    private Integer categoryId;

    private Integer parentId;

    private Integer categoryLevel;

    private String categoryName;

    private List<ProductCategoryBO> children = new ArrayList<>();
    
}
