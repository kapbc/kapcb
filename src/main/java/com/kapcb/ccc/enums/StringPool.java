package com.kapcb.ccc.enums;

import org.springframework.lang.NonNull;

/**
 * <a>Title: StringPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: StringPool <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:39
 */
public enum StringPool {

    /**
     * Common Constants
     */
    SEMICOLON(";", "分号"),
    COLON(":", "冒号"),
    COMMA(",", "逗号"),
    SPACE(" ", "空格"),
    HYPHEN("-", "横杠"),
    SPACE_HYPHEN(" - ", "空格横杠"),
    UNDER_CROSS("_", "下划线"),
    SPACE_COMMA(" ,", "空格逗号"),
    EMPTY_STRING("", "空字符串"),
    SINGLE_QUOTES("'", "单引号"),
    SHARP("#", "#号"),
    STAR("*", "*号"),
    AT_SIGN("@", "@号"),
    PERCENT_SIGN("%", "%号"),
    DOLLAR_SIGN("$", "$号"),
    EXCLAMATION_SIGN("!", "!号"),
    SLASH("/", "斜杠"),
    DOT(".", "点"),
    ARE_BRACKET("(", "正括号"),
    PARENTHESES(")", "反括号"),
    EMPTY_OBJECT("{}", "空对象"),

    ZERO("0", "字符串0"),
    ONE("1", "字符串1"),
    FIVE("5", "字符串5"),
    TEN("10", "字符串10"),

    /**
     * SQL programmer
     */
    ORDER("ORDER", "SQL排序"),
    ACS("ASC", "SQL正序"),
    DESC("DESC", "SQL倒序"),
    LIMIT("LIMIT", "SQL限定数量"),


    /**
     * Server Configuration Document Key
     */
    SERVER_APPLICATION_NAME("spring.application.name", "获取服务名称"),
    SERVER_PORT("server.port", "获取服务端口号"),

    /**
     * Http Servlet Request
     */
    HTTP_REQUEST_UN_KNOWN("unknown", "未知"),
    HTTP_REQUEST_X_FOR_WARDED_FOR("x-forwarded-for", "获取ip地址请求中的key"),
    HTTP_REQUEST_PROXY_CLIENT_IP("Proxy-Client-IP", "获取ip地址请求中的key"),
    HTTP_REQUEST_WL_PROXY_CLIENT_IP("WL-Proxy-Client-IP", "获取ip地址请求中的key"),
    HTTP_REQUEST_HTTP_CLIENT_IP("HTTP_CLIENT_IP", "获取ip地址请求中的key"),
    HTTP_REQUEST_HTTP_X_FORWARDED_FOR("HTTP_X_FORWARDED_FOR", "获取ip地址请求中的key"),
    HTTP_REQUEST_AUTHORIZATION("Authorization", "http请求头中的Authorization"),
    AUTHORIZATION_BEARER("Bearer ", "Bearer "),

    /**
     * End Point Log Aspect
     */
    END_POINT_LOG_SPILT_LINE("[----------------------------------------------------------------------]", "spilt line"),
    END_POINT_LOG_COST_TIME("request process cost time : {}", "request process cost time"),
    END_POINT_LOG_SERVER_NAME("server name is : {}", "server name"),
    END_POINT_LOG_REQUEST_URI("request uri is : {}", "request uri"),
    END_POINT_LOG_REQUEST_URL("request url is : {}", "request url"),
    END_POINT_LOG_METHOD_NAME("request process method name : {}", "method name"),
    END_POINT_LOG_CLASS_NAME("request process class name : {}", "class name"),
    END_POINT_LOG_REQUEST_TIME("request time : {}", "request time"),
    END_POINT_LOG_RETURN_VALUE("request return value is : {}", "return value"),
    END_POINT_LOG_ERROR_MESSAGE("handler request error, error message is : {}", "error message"),

    CHINESE_MATCH_REGEX("[\\u4e00-\\u9fa5]", "chinese match regex"),


    DICTIONARY_REMARK_CAPITAL_CITY("capital", "capital city remark"),
    DICTIONARY_REMARK_NON_CAPITAL_CITY("default", "non capital city remark"),
    DICTIONARY_GROUP_COUNTRY("country", "dictionary country group"),
    DICTIONARY_GROUP_CITY("city", "dictionary city group"),
    DICTIONARY_GROUP_PROVINCE("province", "dictionary province group");

    private String value;
    private String description;

    StringPool(String value, String description) {
        this.value = value;
        this.description = description;
    }

    @NonNull
    public String value() {
        return this.value;
    }
}