package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.mapper.PermissionMapper;
import com.kapcb.ccc.model.po.PermissionPO;
import com.kapcb.ccc.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <a>Title: PermissionServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/5 21:58
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionPO> implements IPermissionService {
}
