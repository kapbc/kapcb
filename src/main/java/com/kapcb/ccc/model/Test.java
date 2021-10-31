package com.kapcb.ccc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <a>Title: Test </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Test <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/31 12:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Test {

    private Boolean condition;

    private Integer id;

    private String content;
}
