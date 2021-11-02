package com.kapcb.ccc.configure;

import com.kapcb.ccc.properties.Swagger2Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <a>Title: Swagger2Configuration </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:36
 */
@Slf4j
@Configuration
@EnableSwagger2
public class Swagger2Configuration extends BaseSwaggerConfig {

    @Override
    public Swagger2Properties swagger2Properties() {
        Swagger2Properties swagger2Properties = new Swagger2Properties();
        swagger2Properties.setBasePackage("com.kapcb.ccc.controller");
        swagger2Properties.setContactEmail("eircccallroot@yeah.net");
        swagger2Properties.setContactName("Kapcb");
        swagger2Properties.setContactUrl("https://github.com/kapbc/kapcb/issues");
        swagger2Properties.setDescription("Kapcb");
        swagger2Properties.setTitle("Kapcb's Swagger Api Document");
        swagger2Properties.setEnableSecurity(true);
        swagger2Properties.setVersion("1.0.0");
        return swagger2Properties;
    }

}
