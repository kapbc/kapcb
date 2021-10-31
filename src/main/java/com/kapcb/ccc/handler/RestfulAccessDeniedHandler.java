package com.kapcb.ccc.handler;

import com.kapcb.ccc.common.result.CommonResult;
import com.kapcb.ccc.utils.ResultUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <a>Title: RestfulAccessDeniedHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RestfulAccessDeniedHandler <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/29 22:15
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResultUtil.setUpJSONResponse(httpServletResponse, CommonResult.forbidden());
    }
}
