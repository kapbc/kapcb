package com.kapcb.ccc.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.lang.NonNull;

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
@UtilityClass
public class ResultUtil {

    @NonNull
    public static <T> List<T> resultList(List<T> data) {
        return CollectionUtils.isNotEmpty(data) ? data : Collections.emptyList();
    }

    @NonNull
    public static <T> Set<T> resultSet(List<T> data) {
        return CollectionUtils.isNotEmpty(data) ? new HashSet<>(data) : Collections.emptySet();
    }
}