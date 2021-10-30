package com.kapcb.ccc.configure;

import com.kapcb.ccc.filter.CustomAuthenticationFilter;
import com.kapcb.ccc.filter.JwtAuthenticationFilter;
import com.kapcb.ccc.handler.LoginAuthenticationFailureHandler;
import com.kapcb.ccc.handler.LoginAuthenticationSuccessHandler;
import com.kapcb.ccc.handler.RestAuthenticationEntryPoint;
import com.kapcb.ccc.handler.RestfulAccessDeniedHandler;
import com.kapcb.ccc.service.impl.UsernameUserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <a>Title: SecurityConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SecurityConfiguration <a>
 * AuthenticationFilter that supports rest login(json login) and form login.
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/8 13:48
 */
@Slf4j
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UsernameUserDetailService usernameUserDetailService;
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
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
        http.csrf()
                .disable() // 使用JWT, 不需要csrf
                .sessionManagement() // 基于token, 所以不需要使用session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/static/**", "/category/**", "/dictionary/**") // 允许对静态资源文件的无授权访问
                .permitAll()
                .antMatchers("/login", "/register") // 允许登录注册
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS) // 跨域请求会先进行一次options试探请求
                .permitAll()
//                .antMatchers("/**") // 测试时允许所有请求
//                .permitAll()
                .anyRequest() // 以上之外的所有请求都需要鉴权认证
                .authenticated()
                .and().formLogin()
                .loginProcessingUrl("/login");

        // 禁用缓存
        http.headers().cacheControl();


        // 使用JWT 关闭token
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .cors().and().authorizeRequests()
//                .antMatchers("/static/**", "/category/**", "/dictionary/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login")
//                .successHandler(loginAuthenticationSuccessHandler)
//                .failureHandler(loginAuthenticationFailureHandler)
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessHandler()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new OrRequestMatcher(
//                        new AntPathRequestMatcher("/logout", "GET"),
//                        new AntPathRequestMatcher("/logout1", "POST")
//                ))
//                .defaultLogoutSuccessHandlerFor((request, response, auth) -> {
//                    response.setContentType(ContentType.JSON.getValue());
//                    Map<String, String> resultMap = HashMap.of("msg", "logout success!", "data", "kapcb logout success!", "code", "200");
//                    response.getWriter().write(JSON.toJSONString(resultMap));
//                    response.getWriter().flush();
//                    response.getWriter().close();
//                }, new AntPathRequestMatcher("/logout", "GET"))
//                .defaultLogoutSuccessHandlerFor((request, response, auth) -> {
//                    response.setContentType(ContentType.JSON.getValue());
//                    Map<String, String> resultMap = HashMap.of("msg", "logout1 success!", "data", "kapcb logout1 success!", "code", "200");
//                    response.getWriter().write(JSON.toJSONString(resultMap));
//                    response.getWriter().flush();
//                    response.getWriter().close();
//                }, new AntPathRequestMatcher("/logout1", "POST"))
//                .and().csrf().disable();

        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        // 用重写的Filter替换掉原有的UsernamePasswordAuthenticationFilter
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        // 添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

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
        // 重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        customAuthenticationFilter.setAuthenticationManager(authenticationManager());
        return customAuthenticationFilter;
    }

    /**
     * 配置跨域
     *
     * @return CorsFilter
     */
    @Bean
    public CorsFilter corsFilter() {
        log.info("-----------------begin initial cors filter-----------------");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usernameUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Bean
//    public SimpleUrlAuthenticationFailureHandler failureHandler() {
//        SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler = new SimpleUrlAuthenticationFailureHandler();
//        simpleUrlAuthenticationFailureHandler.setDefaultFailureUrl("/login.html");
//        simpleUrlAuthenticationFailureHandler.setUseForward(true);
//        return simpleUrlAuthenticationFailureHandler;
//    }
}
