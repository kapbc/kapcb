package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.po.RolePO;

import java.util.Set;

/**
 * <a>Title: RoleService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/5 21:55
 */
public interface IRoleService extends IService<RolePO> {

    Set<RolePO> getUserRoles(Long userId);

}
