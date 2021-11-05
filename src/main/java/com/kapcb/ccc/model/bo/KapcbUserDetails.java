package com.kapcb.ccc.model.bo;

import com.kapcb.ccc.model.po.admin.UserPO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a>Title: KapcbUserDetails </a>
 * <a>Author: Kapcb <a>
 * <a>Description: KapcbUserDetails <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/2 22:16
 */
public class KapcbUserDetails implements UserDetails {

    private static final long serialVersionUID = -6312732067368026349L;

    private UserPO userPO;

    private List<RolePO> permissionList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isNotEmpty(permissionList)) {
            return permissionList.parallelStream().map(role -> new SimpleGrantedAuthority(role.getRoleIdentify())).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public String getPassword() {
        return userPO.getPassword();
    }

    @Override
    public String getUsername() {
        return userPO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return userPO.getAvailableStatus();
    }
}
