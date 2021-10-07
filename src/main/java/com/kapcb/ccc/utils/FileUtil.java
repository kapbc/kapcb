package com.kapcb.ccc.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.io.InputStream;

/**
 * <a>Title: FileUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: FileUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/3 1:24
 */
@Slf4j
@UtilityClass
public class FileUtil {

    public static InputStream getResourcesFileInputStream(@NonNull String filename) {
        log.info("file name is : {}", filename);
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + filename);
    }

    public static String getPath() {
        String path = FileUtil.class.getResource("/").getPath();
        log.info("the path is : {}", path);
        return path;
    }
}
