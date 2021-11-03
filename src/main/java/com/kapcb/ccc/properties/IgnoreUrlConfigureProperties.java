package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: IgnoreUrlConfigureProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IgnoreUrlConfigureProperties <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/3 22:41
 */
@Data
@ConfigurationProperties(prefix = "kapcb.security.ignored")
public class IgnoreUrlConfigureProperties {

    private List<String> urls = new ArrayList<>();

}
