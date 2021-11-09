//package com.kapcb.ccc.service.impl;
//
//import com.kapcb.ccc.enums.StringPool;
//import com.kapcb.ccc.mapper.UserMapper;
//import com.kapcb.ccc.model.po.admin.UserPO;
//import com.kapcb.ccc.service.IUserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.lang.NonNull;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * <a>Title: UserServiceImpl </a>
// * <a>Author: Kapcb <a>
// * <a>Description:  <a>
// *
// * @author Kapcb
// * @version 1.0.0
// * @date 2021/7/31 13:46
// */
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements IUserService {
//
//    @Override
//    public List<UserPO> getStoreUserInfoList(Long storeId) {
//        return Collections.emptyList();
//    }
//
//    @Override
//    public UserPO getUserByEmail(String email) {
//        return this.baseMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getEmail, email).orderByDesc(UserPO::getCreateDate).last("LIMIT 1"));
//    }
//
//    @Override
//    public UserPO getUserByUsername(@NonNull String username) {
//        LambdaQueryWrapper<UserPO> wrapper = Wrappers.lambdaQuery();
//        return this.baseMapper.selectOne(wrapper.eq(StringUtils.isNoneBlank(username), UserPO::getUsername, username).last(StringPool.LIMIT.value() + " 1"));
//    }
//
//    @Override
//    public UserPO getUserByTelephone(String phoneNumber) {
//        return this.baseMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getTelephoneNumber, phoneNumber).orderByDesc(UserPO::getCreateDate).last("LIMIT 1"));
//    }
//}
