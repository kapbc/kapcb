package com.kapcb.ccc.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <a>Title: AccessAddressUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/14 13:50
 */
@Slf4j
@UtilityClass
public class AccessAddressUtil {

    private static final String UN_KNOWN = "unknown";
    private static final String X_FOR_WARDED_FOR = "x-forwarded-for";
    private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    private static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    private static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个, 而是一串IP值, 这种情况要获取ip, 只需要取X-Forwarded-For中第一个非unknown的有效IP字符串
     * 如：X-Forwarded-For: 192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.110就是ip地址
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader(X_FOR_WARDED_FOR);
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(UN_KNOWN, ip)) {
            ip = request.getHeader(PROXY_CLIENT_IP);
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(UN_KNOWN, ip)) {
            ip = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(UN_KNOWN, ip)) {
            ip = request.getHeader(HTTP_CLIENT_IP);
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(UN_KNOWN, ip)) {
            ip = request.getHeader(HTTP_X_FORWARDED_FOR);
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(UN_KNOWN, ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
