package com.kapcb.ccc.service;

import com.kapcb.ccc.model.dto.user.req.UserListRequestDTO;
import com.kapcb.ccc.model.index.UserIndex;
import kapcb.framework.web.model.base.BasePageResult;

import java.util.List;

/**
 * <a>Title: UserSearchService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 13:19
 */
public interface IUserSearchService {

    Boolean syncUserInfoToElasticsearch(Long storeId);

    BasePageResult<UserIndex> getUserList(UserListRequestDTO requestDTO);
}
