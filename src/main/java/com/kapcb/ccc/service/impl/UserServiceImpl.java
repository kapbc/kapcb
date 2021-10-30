package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.enums.StringPool;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: UserServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 13:46
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements IUserService {

    @SuppressWarnings("serial")
    private static final List<UserPO> USER_LIST = new ArrayList<UserPO>() {{
        add(UserPO.builder().userId(1L).age(18).firstName("Mike").lastName("Chen").nickName("Kapcb").storeId(2000000000L).build());
        add(UserPO.builder().userId(2L).age(19).firstName("Chase").lastName("Chen").nickName("fly").storeId(2000000000L).build());
        add(UserPO.builder().userId(3L).age(33).firstName("Edson").lastName("Chen").nickName("fan").storeId(2000000000L).build());
        add(UserPO.builder().userId(4L).age(23).firstName("Even").lastName("Chen").nickName("Even").storeId(2000000000L).build());
        add(UserPO.builder().userId(5L).age(45).firstName("James").lastName("Liang").nickName("James").storeId(2000000000L).build());
        add(UserPO.builder().userId(6L).age(28).firstName("Jack").lastName("Chen").nickName("Jack").storeId(2000000000L).build());
        add(UserPO.builder().userId(7L).age(58).firstName("Iris").lastName("Chen").nickName("Iris").storeId(2000000000L).build());
        add(UserPO.builder().userId(8L).age(48).firstName("Teresa").lastName("Chen").nickName("Teresa").storeId(2000000000L).build());
        add(UserPO.builder().userId(9L).age(34).firstName("Mike").lastName("Sun").nickName("Mike").storeId(2000000000L).build());
        add(UserPO.builder().userId(10L).age(28).firstName("Eliza").lastName("Chen").nickName("Eliza").storeId(2000000000L).build());
        add(UserPO.builder().userId(11L).age(22).firstName("Frank").lastName("Liu").nickName("Frank").storeId(2000000000L).build());
        add(UserPO.builder().userId(12L).age(15).firstName("Kerry").lastName("Chen").nickName("Kerry").storeId(2000000000L).build());
        add(UserPO.builder().userId(13L).age(27).firstName("Kyrie").lastName("lrving").nickName("lrving").storeId(2000000000L).build());
        add(UserPO.builder().userId(14L).age(28).firstName("Kevin").lastName("Love").nickName("Love").storeId(2000000000L).build());
        add(UserPO.builder().userId(15L).age(29).firstName("Kevin").lastName("Durant").nickName("Durant").storeId(2000000000L).build());
        add(UserPO.builder().userId(16L).age(18).firstName("Russell").lastName("Westbrook").nickName("Russell").storeId(2000000000L).build());
        add(UserPO.builder().userId(17L).age(19).firstName("Russell").lastName("Rose").nickName("Rose").storeId(2000000000L).build());
        add(UserPO.builder().userId(18L).age(19).firstName("James").lastName("Harden").nickName("James").storeId(2000000000L).build());
        add(UserPO.builder().userId(19L).age(13).firstName("James").lastName("LeBron").nickName("James").storeId(2000000000L).build());
        add(UserPO.builder().userId(20L).age(16).firstName("James").lastName("Johnson").nickName("Kapcb").storeId(2000000000L).build());
    }};


    @Override
    public List<UserPO> getStoreUserInfoList(Long storeId) {
        return USER_LIST;
    }

    @Override
    public UserPO getUserByEmail(String email) {
        return this.baseMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, email).orderByDesc(UserPO::getCreateDate).last("LIMIT 1"));
    }

    @Override
    public UserPO getUserByUsername(@NonNull String username) {
        LambdaQueryWrapper<UserPO> wrapper = Wrappers.lambdaQuery();
        return this.baseMapper.selectOne(wrapper.eq(StringUtils.isNoneBlank(username), UserPO::getNickName, username).last(StringPool.LIMIT.value() + " 1"));
    }

    @Override
    public UserPO getUserByTelephone(String phoneNumber) {
        return this.baseMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getTelephoneNumber, phoneNumber).orderByDesc(UserPO::getCreateDate).last("LIMIT 1"));
    }
}
