package com.kapcb.ccc.configure;

import com.kapcb.framework.logging.collector.ILogCollector;
import com.kapcb.framework.logging.processor.ILog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <a>Title: CustomerLogCollector </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomerLogCollector <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/11/27 18:56
 * @since 1.0
 */
@Slf4j
@Component
public class CustomerLogCollector implements ILogCollector {

    @Override
    public void collect(ILog logInfo) {
        System.out.println("logInfo = " + logInfo);
    }
}
