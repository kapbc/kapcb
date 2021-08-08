package com.kapcb.ccc.common.util;

import cn.hutool.core.date.DateUtil;
import com.kapcb.ccc.common.constants.DatePatternPool;
import com.kapcb.ccc.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;


/**
 * <a>Title: KapcbUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/7 13:28
 */
@Slf4j
@UtilityClass
public class KapcbUtil {

    public static void serverStartUpBanner(Environment environment) {
        String banner = "\n----------------------------------------------------------------------------------\n" +
                "server start success, current time is : " + DateUtil.format(LocalDateTime.now(), DatePatternPool.NORM_DATETIME_PATTERN) + "\n" +
                "server name : " + environment.getProperty(StringPool.SERVER_APPLICATION_NAME.value()) + "\n" +
                "server port : " + environment.getProperty(StringPool.SERVER_PORT.value()) + "\n" +
                "----------------------------------------------------------------------------------";
        log.info(banner);
    }
}
