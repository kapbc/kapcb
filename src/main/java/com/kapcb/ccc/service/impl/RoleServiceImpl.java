package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.common.util.ResultUtil;
import com.kapcb.ccc.mapper.RoleMapper;
import com.kapcb.ccc.model.po.RolePO;
import com.kapcb.ccc.service.IRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <a>Title: RoleServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/8/5 21:54
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RolePO> implements IRoleService {

    @Override
    public Set<RolePO> getUserRoles(Long userId) {
        List<RolePO> rolePOList = this.baseMapper.selectList(new LambdaQueryWrapper<RolePO>().eq(RolePO::getUserId, userId));
        return ResultUtil.conditionSet(rolePOList);
    }
}
