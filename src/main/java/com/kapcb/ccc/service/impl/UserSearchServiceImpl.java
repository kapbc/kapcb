package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.model.dto.user.req.UserListRequestDTO;
import com.kapcb.ccc.model.index.UserIndex;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.UserSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

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

    @Override
    public List<UserIndex> getUserList(UserListRequestDTO requestDTO) {

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        /**
         * must(QueryBuilder queryBuilder)  //返回的文档必须满足must子句的条件,并且参与计算分值
         * mustNot(QueryBuilder queryBuilder)  //返回的文档必须不满足定义的条件
         * should(QueryBuilder queryBuilder))  //返回的文档可能满足should子句的条件.在一个bool查询中,如果没有must或者filter,有一个或者多个should子句,那么只要满足一个就可以返回.minimum_should_match参数定义了至少满足几个子句
         * filter(QueryBuilder queryBuilder))  //返回的文档必须满足filter子句的条件,但是不会像must一样,参与计算分值
         */

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("store_id", requestDTO.getStoreId()).minimumShouldMatch("80%"));
        boolQueryBuilder.should(QueryBuilders.fuzzyQuery("first_name", requestDTO.getQuery()))
                .should(QueryBuilders.fuzzyQuery("last_name", requestDTO.getQuery()))
                .should(QueryBuilders.fuzzyQuery("nick_name", requestDTO.getQuery())).minimumShouldMatch(1);
        queryBuilder.withQuery(boolQueryBuilder);
        Pageable pageRequest = PageRequest.of(requestDTO.getPageNum().intValue() - 1, requestDTO.getPageSize().intValue());
        queryBuilder.withPageable(pageRequest);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<strong>").postTags("</strong>").field("first_name").field("last_name").field("nick_name");
        queryBuilder.withHighlightBuilder(highlightBuilder);
        NativeSearchQuery build = queryBuilder.build();
        SearchHits<UserIndex> search = elasticsearchOperations.search(build, UserIndex.class);
        System.out.println("search = " + search);
        return null;
    }
}
