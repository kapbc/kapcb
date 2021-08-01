package com.kapcb.ccc.service.impl;

import cn.hutool.core.util.PageUtil;
import com.kapcb.ccc.model.dto.user.req.UserListRequestDTO;
import com.kapcb.ccc.model.index.UserIndex;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.UserSearchService;
import kapcb.framework.web.model.base.BasePageResult;
import kapcb.framework.web.util.OrikaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<UserIndex> userIndices = OrikaUtil.mapList(storeUserInfoList, UserIndex.class);
        elasticsearchOperations.save(userIndices);
        return true;
    }

    @Override
    public BasePageResult<UserIndex> getUserList(UserListRequestDTO requestDTO) {

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        /**
         * must(QueryBuilder queryBuilder)  //返回的文档必须满足must子句的条件,并且参与计算分值
         * mustNot(QueryBuilder queryBuilder)  //返回的文档必须不满足定义的条件
         * should(QueryBuilder queryBuilder))  //返回的文档可能满足should子句的条件.在一个bool查询中,如果没有must或者filter,有一个或者多个should子句,那么只要满足一个就可以返回.minimum_should_match参数定义了至少满足几个子句
         * filter(QueryBuilder queryBuilder))  //返回的文档必须满足filter子句的条件,但是不会像must一样,参与计算分值
         * QueryBuilders.matchQuery()表示模糊查询
         * QueryBuilders.termQuery()表示精确查询
         */

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("store_id", requestDTO.getStoreId()).minimumShouldMatch("80%"));
        if (StringUtils.isNoneBlank(requestDTO.getQuery())) {
            // 根据一个值查询多个字段  并高亮显示  这里的查询是取并集，即多个字段只需要有一个字段满足即可
            // 需要查询的字段
            boolQueryBuilder.should(QueryBuilders.matchQuery("first_name", requestDTO.getQuery()))
                    .should(QueryBuilders.matchQuery("last_name", requestDTO.getQuery()))
                    .should(QueryBuilders.matchQuery("nick_name", requestDTO.getQuery())).minimumShouldMatch(1);
//            boolQueryBuilder.should(QueryBuilders.multiMatchQuery(requestDTO.getQuery(), "first_name", "last_name", "nick_name")).minimumShouldMatch(1);
        }
        queryBuilder.withQuery(boolQueryBuilder);
        queryBuilder.withSort(SortBuilders.scoreSort());
        Pageable pageRequest = PageRequest.of(requestDTO.getPageNum().intValue() - 1, requestDTO.getPageSize().intValue());
        queryBuilder.withPageable(pageRequest);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<strong>").postTags("</strong>").field("first_name").field("last_name").field("nick_name");
        queryBuilder.withHighlightBuilder(highlightBuilder);
        NativeSearchQuery build = queryBuilder.build();
        build.setTrackTotalHits(true);
        SearchHits<UserIndex> search = elasticsearchOperations.search(build, UserIndex.class);
        System.out.println("search = " + search);
        List<UserIndex> userIndexList = search.stream().map(index -> {
            UserIndex content = index.getContent();
            Map<String, List<String>> highlightFields = index.getHighlightFields();
            if (MapUtils.isNotEmpty(highlightFields)) {
                if (highlightFields.containsKey("firstName")) {
                    content.setFirstName(highlightFields.get("firstName").get(0));
                }
                if (highlightFields.containsKey("lastName")) {
                    content.setLastName(highlightFields.get("lastName").get(0));
                }
                if (highlightFields.containsKey("nickName")) {
                    content.setNickName(highlightFields.get("nickName").get(0));
                }
            }
            return content;
        }).collect(Collectors.toList());
        BasePageResult<UserIndex> pageResult = new BasePageResult<>();
        pageResult.setRecords(userIndexList);
        pageResult.setTotal(search.getTotalHits());
        pageResult.setPageSize(requestDTO.getPageSize());
        pageResult.setPageNum(requestDTO.getPageNum());
        pageResult.setTotalPage(PageUtil.totalPage((int) pageResult.getTotal(), requestDTO.getPageSize().intValue()));
        return pageResult;
    }
}
