//package com.kapcb.ccc.manager;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.Serializable;
//
///**
// * <a>Title: SessionManager </a>
// * <a>Author: Kapcb <a>
// * <a>Description:  <a>
// * 自定义Session会话管理器
// * 传统结构项目中, Shiro从Cookie中读取SessionId以此来维持会话, 在前后端分离的项目中
// * 或者App项目, 可以选择在Ajax的请求头中传递SessionId, 因此需要重写Shiro获取SessionId的方式
// *
// * @author Kapcb
// * @version 1.0.0
// * @date 2021/8/4 21:37
// */
//@Slf4j
//public class SessionManager extends DefaultWebSessionManager {
//
////    private static final String AUTHORIZATION = "Authorization";
////
////    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
////
////    @Override
////    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
////        // 获取SessionId
////        String sessionId = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
////        log.info("the session id is ::: " + sessionId);
////        if (StringUtils.isNoneBlank(sessionId)) {
////            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
////            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
////            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
////            return sessionId;
////        } else {
////            // 否则按默认规则从cookie取sessionId
////            return super.getSessionId(request, response);
////        }
////    }
//}
