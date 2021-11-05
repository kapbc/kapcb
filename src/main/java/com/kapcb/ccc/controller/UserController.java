package com.kapcb.ccc.controller;

import com.kapcb.ccc.model.base.BasePageResult;
import com.kapcb.ccc.model.dto.user.req.UserListRequestDTO;
import com.kapcb.ccc.model.index.UserIndex;
import com.kapcb.ccc.model.po.admin.UserPO;
import com.kapcb.ccc.service.IUserSearchService;
import com.kapcb.ccc.service.IUserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <a>Title: UserController </a>
 * <a>Author: Kapcb <a>
 * <a>Description: UserController <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 14:49
 */
@Slf4j
@RestController
@Api(tags = "用户相关接口")
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final IUserService userService;
    private final IUserSearchService userSearchService;

    @GetMapping("sync/{storeId}")
    public Boolean sync(@PathVariable("storeId") Long storeId) {
        return userSearchService.syncUserInfoToElasticsearch(storeId);
    }

    @PostMapping("search")
    public BasePageResult<UserIndex> searchUser(@RequestBody UserListRequestDTO requestDTO) {
        return userSearchService.getUserList(requestDTO);
    }

    @GetMapping("test/{username}")
    public UserPO test(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}
