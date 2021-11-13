package com.kapcb.ccc.configure;

import com.kapcb.framework.security.configuration.CustomSecurityConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <a>Title: WebSecurityConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: WebSecurityConfiguration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/9 22:15
 */
@Slf4j
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfiguration extends CustomSecurityConfiguration {

    private final UserDetailsService usernameUserDetailService;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return usernameUserDetailService;
    }
}
