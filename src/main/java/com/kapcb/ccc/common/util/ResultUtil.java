package com.kapcb.ccc.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a>Title: ResultUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/7 0:02
 */
@Slf4j
public class ResultUtil {

    private ResultUtil() {
    }

    @NonNull
    public static <T> List<T> conditionList(List<T> data) {
        return CollectionUtils.isNotEmpty(data) ? data : Collections.emptyList();
    }

    @NonNull
    public static <T> Set<T> conditionSet(List<T> data) {
        return CollectionUtils.isNotEmpty(data) ? new HashSet<>(data) : Collections.emptySet();
    }
}
