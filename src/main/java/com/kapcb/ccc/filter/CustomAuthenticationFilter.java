package com.kapcb.ccc.filter;

import com.kapcb.ccc.common.util.JsonUtil;
import com.kapcb.ccc.model.dto.user.AuthenticationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        // attempt Authentication when Content-Type is json
        if (MediaType.APPLICATION_JSON_UTF8_VALUE.equals(request.getContentType()) || MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())) {
            // use jackson to deserialize json
            UsernamePasswordAuthenticationToken authRequest = null;

            try (InputStream inputStream = request.getInputStream()) {
                log.info("the input stream is : {}", inputStream);
                // deserialize json to get loginInfo
                String json = inputStream.toString();
                log.info("the json string is : {}", json);
                AuthenticationDTO authenticationDTO = JsonUtil.convertJsonToData(json, AuthenticationDTO.class);
                if (Objects.nonNull(authenticationDTO)) {
                    authRequest = new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword());
                }
            } catch (IOException e) {
                log.error("use json login error, error message is : {}", e.getMessage());
                authRequest = new UsernamePasswordAuthenticationToken("", "");
            } finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        } else {
            // If not,transmit it to UsernamePasswordAuthenticationFilter
            return super.attemptAuthentication(request, response);
        }
    }
}
