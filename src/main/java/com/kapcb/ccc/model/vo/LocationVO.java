package com.kapcb.ccc.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <a>Title: CountryCityVO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CountryCityVO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/28 22:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class LocationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer parentId;

    private Integer id;

    private String locationEn;

    private String locationZh;

    private List<LocationVO> children;
}
