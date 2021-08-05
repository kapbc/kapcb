package com.kapcb.ccc.authentication;

import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IPermissionService;
import com.kapcb.ccc.service.IRoleService;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

import javax.annotation.PostConstruct;
import java.util.Objects;

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

    private final IUserService userService;
    private final IRoleService roleService;
    private final IPermissionService permissionService;

    @PostConstruct
    public void initConfigure(){
        setAuthenticationCachingEnabled(false);
        setAuthorizationCachingEnabled(true);
        setCachingEnabled(true);
    }

    /**
     * 授权
     *
     * @param principalCollection PrincipalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken AuthenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info(":::begin to authentication::: {}", authenticationToken);

        // 获取登录的用户名
        String email = (String) authenticationToken.getPrincipal();
        if (StringUtils.isNoneBlank(email)) {
            // 可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
            UserPO userPO = userService.getUserByUsername(email);
            if (Objects.isNull(userPO)) {
                throw new IncorrectCredentialsException("username or password error!");
            }
            if (userPO.getAvailableStatus()) {
                throw new LockedAccountException("account is locked!");
            }
            // 这里传入的是user对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
            // 密码
            // salt
            // realm name
            return new SimpleAuthenticationInfo(userPO, userPO.getPassword(), new SimpleByteSource("aaa"), getName());
        }
        return null;
    }
}
