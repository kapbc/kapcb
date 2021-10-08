package com.kapcb.ccc.filter;

import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.model.dto.user.AuthenticationDTO;
import com.kapcb.ccc.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Objects;

/**
 * <a>Title: CustomAuthenticationFilter </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/8 15:33
 */
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!HttpMethod.POST.name().equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported : " + request.getMethod());
        }
        // attempt Authentication when Content-Type is json
        if (MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(request.getContentType()) || MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType()) || MediaType.APPLICATION_JSON_UTF8_VALUE.equals(request.getContentType())) {
            // use jackson to deserialize json
            String username = StringPool.EMPTY_STRING.value();
            String password = StringPool.EMPTY_STRING.value();
            // 通过流解析出json, get delete请求就没有流
            try (InputStream inputStream = request.getInputStream()) {
                AuthenticationDTO authentication = JsonUtil.readValue(inputStream, AuthenticationDTO.class);
                log.info("authentication params is : {}", authentication);
                if (Objects.nonNull(authentication)) {
                    username = authentication.getUsername();
                    password = authentication.getPassword();
                }
            } catch (Exception e) {
                log.error("use json login error, error message is : {}", e.getMessage());
            }

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username.trim(), password.trim());
            return this.getAuthenticationManager().authenticate(authRequest);
        } else {
            // 如果不是使用json传递参数, 则调用父类的方式获取参数
            return super.attemptAuthentication(request, response);
        }
    }
}
