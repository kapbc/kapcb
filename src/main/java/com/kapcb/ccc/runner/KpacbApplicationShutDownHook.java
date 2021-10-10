package com.kapcb.ccc.runner;

import com.kapcb.ccc.utils.KapcbUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


/**
 * <a>Title: KpacbWebShutDownHook </a>
 * <a>Author: Kapcb <a>
 * <a>Description: KpacbApplicationShutDownHook <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/5 22:28
 */
@Slf4j
@Component
public class KpacbApplicationShutDownHook {

    @EventListener(classes = {ContextClosedEvent.class})
    public void applicationShutDownHook(@NonNull ApplicationEvent applicationEvent) {
        KapcbUtil.serverShutDownHookBanner();
    }
}
