package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.po.admin.UserPO;

import java.util.List;

/**
 * <a>Title: IUserService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 13:46
 */
public interface IUserService extends IService<UserPO> {

    List<UserPO> getStoreUserInfoList(Long storeId);

    UserPO getUserByEmail(String email);

    UserPO getUserByUsername(String username);

    UserPO getUserByTelephone(String phoneNumber);
}
