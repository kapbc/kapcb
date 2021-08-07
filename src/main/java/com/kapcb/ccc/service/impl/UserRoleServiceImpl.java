package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.mapper.UserRoleMapper;
import com.kapcb.ccc.model.po.UserRolePO;
import com.kapcb.ccc.service.IUserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <a>Title: UserRoleServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/7 21:46
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRolePO> implements IUserRoleService {
}
