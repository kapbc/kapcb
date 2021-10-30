package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * <a>Title: UsernameUserDetailService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/15 15:12
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UsernameUserDetailService implements UserDetailsService {

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPO userByUsername = userService.getUserByUsername(username);
        log.info("user by username is : {}", userByUsername);
        if (Objects.isNull(userByUsername)) {
            throw new UsernameNotFoundException("username or password error!");
        }
        List<GrantedAuthority> boss = AuthorityUtils.commaSeparatedStringToAuthorityList("boss");
        return new User(userByUsername.getUsername(), new BCryptPasswordEncoder().encode(userByUsername.getPassword()), boss);
    }
}
