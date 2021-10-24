package com.kapcb.ccc.model.initial;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <a>Title: CityAnalyzeDTO </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CityAnalyzeDTO <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/24 15:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CityAnalyzeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String province;

    private String capitalCity;

    private List<String> nonProvincialCapitalCity;
}
