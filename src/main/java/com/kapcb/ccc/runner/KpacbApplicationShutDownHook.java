package com.kapcb.ccc.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * <a>Title: KpacbWebShutDownHook </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/5 22:28
 */
@Slf4j
@Component
public class KpacbApplicationShutDownHook {

    @EventListener(classes = {ContextClosedEvent.class})
    public void onKapcbApplicationShutDown(@NonNull ApplicationEvent applicationEvent) {
        log.info("-------------------------------------------------------------------------------");
        log.info("--------------------------Kapcb Application Shut Down--------------------------");
        log.info("-----No Matter How High The Mountain Is, One Can Always Ascend To It‘s Top-----");
        log.info("----------------------------------Kapcb----------------------------------------");
        log.info("-------------------------------------------------------------------------------");
    }
}
