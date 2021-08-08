package com.kapcb.ccc.configure;

import cn.hutool.http.ContentType;
import com.alibaba.fastjson.JSON;
import com.kapcb.ccc.filter.CustomAuthenticationFilter;
import com.kapcb.ccc.handler.LoginAuthenticationFailureHandler;
import com.kapcb.ccc.handler.LoginAuthenticationSuccessHandler;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

/**
 * <a>Title: SecurityConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 * AuthenticationFilter that supports rest login(json login) and form login.
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/8 13:48
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;
    private final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;

    /**
     * security configure
     *
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
//                .successHandler(loginAuthenticationSuccessHandler)
//                .failureHandler(loginAuthenticationFailureHandler)
//                .usernameParameter("username")
//                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/logout", "GET"),
                        new AntPathRequestMatcher("/logout1", "POST")
                ))
                .defaultLogoutSuccessHandlerFor((request, response, auth) -> {
                    response.setContentType(ContentType.JSON.getValue());
                    Map<String, String> resultMap = HashMap.of("msg", "logout success!", "data", "kapcb logout success!", "code", "200");
                    response.getWriter().write(JSON.toJSONString(resultMap));
                }, new AntPathRequestMatcher("/logout", "GET"))
                .defaultLogoutSuccessHandlerFor((request, response, auth) -> {
                    response.setContentType(ContentType.JSON.getValue());
                    Map<String, String> resultMap = HashMap.of("msg", "logout1 success!", "data", "kapcb logout1 success!", "code", "200");
                    response.getWriter().write(JSON.toJSONString(resultMap));
                }, new AntPathRequestMatcher("/logout1", "POST"))
                .and().csrf().disable();

        // 用重写的Filter替换掉原有的UsernamePasswordAuthenticationFilter
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 注册自定义的UsernamePasswordAuthenticationFilter
     *
     * @return CustomAuthenticationFilter
     * @throws Exception Exception
     */
    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
        customAuthenticationFilter.setAuthenticationSuccessHandler(loginAuthenticationSuccessHandler);
        customAuthenticationFilter.setAuthenticationFailureHandler(loginAuthenticationFailureHandler);
        // 这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        customAuthenticationFilter.setAuthenticationManager(authenticationManager());
        return customAuthenticationFilter;
    }

//    @Bean
//    public SimpleUrlAuthenticationFailureHandler failureHandler() {
//        SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler = new SimpleUrlAuthenticationFailureHandler();
//        simpleUrlAuthenticationFailureHandler.setDefaultFailureUrl("/login.html");
//        simpleUrlAuthenticationFailureHandler.setUseForward(true);
//        return simpleUrlAuthenticationFailureHandler;
//    }
}
