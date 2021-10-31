package com.kapcb.ccc.utils;

import com.kapcb.ccc.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * <a>Title: RequestUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RequestUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/30 22:23
 */
@Slf4j
@UtilityClass
public class RequestUtil {

    public static boolean ajaxRequest(HttpServletRequest request) {
        String xRequest = request.getHeader(StringPool.REQUEST_HEAD_X_REQUESTED_WITH.value());
        log.info("the request head is {}", xRequest);
        return StringPool.REQUEST_XML_HTTP_REQUEST.value().equals(xRequest);
    }
}
