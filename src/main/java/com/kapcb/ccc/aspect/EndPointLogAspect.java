package com.kapcb.ccc.aspect;

import cn.hutool.core.date.DateUtil;
import com.kapcb.ccc.common.constants.DatePatternPool;
import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.properties.EndPointAutoConfigureProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <a>Title: EndPointLogAspect </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/16 22:45
 */
@Slf4j
@Aspect
@Configuration
@ConditionalOnProperty(prefix = "kapcb.end.point", name = "enable", havingValue = "true")
public class EndPointLogAspect {

    @Resource
    private Environment environment;
    @Resource
    private HttpServletRequest request;
    @Resource
    private EndPointAutoConfigureProperties endPointAutoConfigureProperties;

    @Around("(@within(org.springframework.stereotype.Controller)) || @within(org.springframework.web.bind.annotation.RestController) && execution(public * com.kapcb.ccc..*.controller..*.*(..))")
    public Object EndPointLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalDateTime now = LocalDateTime.now();
        long startTime = System.currentTimeMillis();
        Object returnValue = null;
        Exception exception = null;
        try {
            returnValue = proceedingJoinPoint.proceed();
            return returnValue;
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            log.info(StringPool.END_POINT_LOG_SPILT_LINE.value());
            if (endPointAutoConfigureProperties.isRequestCostTime()) {
                log.info(StringPool.END_POINT_LOG_COST_TIME.value(), System.currentTimeMillis() - startTime);
            }
            if (endPointAutoConfigureProperties.isApplicationName()) {
                log.info(StringPool.END_POINT_LOG_SERVER_NAME.value(), environment.getProperty(StringPool.SERVER_APPLICATION_NAME.value()));
            }
            if (endPointAutoConfigureProperties.isRequestUri()) {
                log.info(StringPool.END_POINT_LOG_REQUEST_URI.value(), request.getRequestURI());
            }
            if (endPointAutoConfigureProperties.isRequestUrl()) {
                log.info(StringPool.END_POINT_LOG_REQUEST_URL.value(), request.getRequestURL());
            }
            if (endPointAutoConfigureProperties.isMethodName()) {
                log.info(StringPool.END_POINT_LOG_METHOD_NAME.value(), proceedingJoinPoint.getSignature().getName());
            }
            if (endPointAutoConfigureProperties.isClassName()) {
                log.info(StringPool.END_POINT_LOG_CLASS_NAME.value(), proceedingJoinPoint.getTarget().getClass().getName());
            }
            if (endPointAutoConfigureProperties.isRequestTime()) {
                log.info(StringPool.END_POINT_LOG_REQUEST_TIME.value(), DateUtil.format(now, DatePatternPool.NORM_DATETIME_PATTERN));
            }
            if (Objects.isNull(exception) && endPointAutoConfigureProperties.isReturnValue()) {
                log.info(StringPool.END_POINT_LOG_RETURN_VALUE.value(), returnValue);
            }
            if (Objects.nonNull(exception) && endPointAutoConfigureProperties.isExceptionMessage()) {
                log.error(StringPool.END_POINT_LOG_ERROR_MESSAGE.value(), exception.getMessage());
            }
            log.info(StringPool.END_POINT_LOG_SPILT_LINE.value());
        }
    }

}
