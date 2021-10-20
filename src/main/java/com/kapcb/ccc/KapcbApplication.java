package com.kapcb.ccc;

import com.kapcb.ccc.annotation.web.KapcbWebApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <a>Title: KapcbApplication </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:19
 */
@EnableAsync
@KapcbWebApplication
public class KapcbApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(KapcbApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
