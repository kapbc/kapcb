package com.kapcb.ccc.utils;

import cn.hutool.core.date.DateUtil;
import com.kapcb.ccc.common.constants.DatePatternPool;
import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.model.Test;
import com.kapcb.ccc.struts.DictionaryConvertMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
                "server name : " + environment.getProperty(StringPool.SERVER_APPLICATION_NAME.value()) + "\n" +
                "server port : " + environment.getProperty(StringPool.SERVER_PORT.value()) + "\n" +
                "server start success, current time is : " + DateUtil.format(LocalDateTime.now(), DatePatternPool.NORM_DATETIME_PATTERN) + "\n" +
                "----------------------------------------------------------------------------------";
        log.info(banner);
    }

    public static void serverShutDownHookBanner() {
        String banner = "\n----------------------------------------------------------------------------------\n" +
                "--------------------------< Kapcb Application Shut Down >-------------------------\n" +
                "-----< No Matter How High The Mountain Is, One Can Always Ascend To It‘s Top >----\n" +
                "----------------------------------< Kapcb >---------------------------------------\n" +
                "----------------------------------------------------------------------------------";
        log.info(banner);
    }

    private static final List<Test> TEST = new ArrayList<Test>() {
        private static final long serialVersionUID = -1098981425854956598L;

        {
            add(Test.builder().id(1).content("1").condition(false).build());
            add(Test.builder().id(2).content("2").condition(true).build());
            add(Test.builder().id(3).content("3").condition(false).build());
            add(Test.builder().id(4).content("4").condition(true).build());
            add(Test.builder().id(5).content("5").condition(false).build());
            add(Test.builder().id(6).content("6").condition(true).build());
        }
    };

    public static void main(String[] args) {
        List<Test> collect = TEST.stream().map(DictionaryConvertMapper.instance::convertTest).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

}
