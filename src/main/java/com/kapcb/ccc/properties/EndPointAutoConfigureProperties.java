package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <a>Title: EndPointAutoConfigureProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/14 14:47
 */
@Data
@ConfigurationProperties(prefix = "kapcb.end.point", ignoreInvalidFields = true, ignoreUnknownFields = false)
public class EndPointAutoConfigureProperties {

    private boolean enable = false;

    private boolean methodName = false;

    private boolean className = false;

    private boolean requestUri = false;

    private boolean requestUrl = false;

    private boolean applicationName = false;

    private boolean requestTime = false;

    private boolean requestCostTime = false;

    private boolean returnValue = false;

    private boolean exceptionMessage = false;
}
