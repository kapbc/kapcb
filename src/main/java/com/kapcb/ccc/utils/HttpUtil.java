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
//        String s = cn.hutool.http.HttpUtil.get("https://wenku.baidu.com/view/0550414ce45c3b3567ec8b43.html");
//        System.out.println("s = " + s);

        String s1 = cn.hutool.http.HttpUtil.get("https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E5%9F%8E%E5%B8%82%E5%90%8D%E7%A7%B0%E5%A4%A7%E5%85%A8/14892072?fr=aladdin");

        System.out.println("s1 = " + s1);
    }
}

