package com.kapcb.ccc.service;

import com.kapcb.ccc.model.dto.user.req.UserListRequestDTO;
import com.kapcb.ccc.model.index.UserIndex;

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
public interface UserSearchService {

    Boolean syncUserInfoToElasticsearch(Long storeId);

    List<UserIndex> getUserList(UserListRequestDTO requestDTO);
}
