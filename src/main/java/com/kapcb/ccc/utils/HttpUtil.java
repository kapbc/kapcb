package com.kapcb.ccc.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * <a>Title: HttpUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: HttpUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/23 12:06
 */
@Slf4j
@UtilityClass
public class HttpUtil {

    public static void main(String[] args) {
        String s = cn.hutool.http.HttpUtil.get("https://wenku.baidu.com/view/0550414ce45c3b3567ec8b43.html");
        System.out.println("s = " + s);

    }
}

