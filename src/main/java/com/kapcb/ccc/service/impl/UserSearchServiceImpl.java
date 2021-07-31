package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.model.index.UserIndex;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.UserSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: UserSearchServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/31 13:19
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserSearchServiceImpl implements UserSearchService {

    private final IUserService userService;
    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public Boolean syncUserInfoToElasticsearch(Long storeId) {
        List<UserPO> storeUserInfoList = userService.getStoreUserInfoList(storeId);
        List<UserIndex> userIndices = new ArrayList<>();
        BeanUtils.copyProperties(storeUserInfoList, userIndices);
        elasticsearchOperations.save(userIndices);
        return true;
    }


}
