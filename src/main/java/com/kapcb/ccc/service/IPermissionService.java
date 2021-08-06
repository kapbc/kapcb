package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.po.PermissionPO;

import java.util.List;
import java.util.Set;

/**
 * <a>Title: IPermissionService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/5 22:01
 */
public interface IPermissionService extends IService<PermissionPO> {

    Set<PermissionPO> getRolePermissions(List<Long> roleIdList);

}
