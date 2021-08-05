package com.kapcb.ccc.shiro;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * <a>Title: KapcbRealm </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 * 自定义Shiro Realm, 重写认证、授权
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/5 21:48
 */
@Slf4j
@RequiredArgsConstructor
public class KapcbRealm extends AuthorizingRealm {



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
