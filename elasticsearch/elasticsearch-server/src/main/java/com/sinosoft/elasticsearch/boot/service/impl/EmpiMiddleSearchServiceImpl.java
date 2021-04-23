package com.sinosoft.elasticsearch.boot.service.impl;

import com.sinosoft.elasticsearch.boot.entity.EmpiMiddleSearch;
import com.sinosoft.elasticsearch.boot.mapper.EmpiMiddleSearchMapper;
import com.sinosoft.elasticsearch.boot.service.EmpiMiddleSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ScrolledPage;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EmpiMiddleSearchServiceImpl implements EmpiMiddleSearchService {
    @Autowired
    private EmpiMiddleSearchMapper empiMiddleSearchMapper;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    /**
     * scroll游标快照超时时间，单位ms
     */
    private static final long SCROLL_TIMEOUT = 3000;

    @Override
    public Page<EmpiMiddleSearch> testSearch() throws Exception {
        //按name进行搜索
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.matchQuery("content", "陈本电"));
        Page<EmpiMiddleSearch> items  = empiMiddleSearchMapper.search(queryBuilder.build());
        return items;
    }

    @Override
    public Page<EmpiMiddleSearch> testSearchPage(int page,int pageSize) throws Exception {
        log.info("searchPage ===> page = {},pageSize = {}",page,pageSize);
        // 分页参数
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        //排序参数
//        SortBuilder sortBuilder1 = SortBuilders.fieldSort("id").order(SortOrder.ASC);
        SortBuilder sortBuilder2 = SortBuilders.fieldSort("content").order(SortOrder.ASC);
        //查询
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.matchQuery("content", "陈本电"));
        queryBuilder.withPageable(pageable);
        queryBuilder.withSort(sortBuilder2);
//        queryBuilder.withSort(sortBuilder1);
        Page<EmpiMiddleSearch> items  = empiMiddleSearchMapper.search(queryBuilder.build());
        return items;
    }

    @Override
    public Page<EmpiMiddleSearch> searchAllPage(int page, int pageSize) throws Exception {
        log.info("searchAllPage ===> page = {},pageSize = {}",page,pageSize);

        // 分页参数
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        //排序参数
        SortBuilder sortBuilder = SortBuilders.fieldSort("id").order(SortOrder.ASC);
        //查询
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("status", "3"));
        queryBuilder.withQuery(boolQueryBuilder);
        queryBuilder.withPageable(pageable);
        queryBuilder.withSort(sortBuilder);
        Page<EmpiMiddleSearch> items  = empiMiddleSearchMapper.search(queryBuilder.build());

        return items;
    }

    @Override
    public List<EmpiMiddleSearch> searchAll() throws Exception {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.mustNot(QueryBuilders.termQuery("status", "3"));
        Iterable<EmpiMiddleSearch> search = empiMiddleSearchMapper.search(boolQueryBuilder);
        List<EmpiMiddleSearch> list = new ArrayList<>();
        for(EmpiMiddleSearch p:search){
            list.add(p);
        }
        return list;
    }

    @Override
    public ScrolledPage<EmpiMiddleSearch> searchAllScrollPage(int page, int pageSize,String scrollId) throws Exception {
        log.info("searchAllScrollPage ===> page = {},pageSize = {}",page,pageSize);

        ScrolledPage<EmpiMiddleSearch> scroll;
        if(StringUtils.isBlank(scrollId)){
            // 分页参数
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            //排序参数
            SortBuilder sortBuilder = SortBuilders.fieldSort("id").order(SortOrder.ASC);
            //查询
//            NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.mustNot(QueryBuilders.termQuery("status", "3"));
            SearchQuery searchQuery = new NativeSearchQueryBuilder()
                    .withIndices("empi_middle")//索引名
                    .withTypes("doc")//类型名
                    .withQuery(boolQueryBuilder)//查询条件，这里简单使用term查询
                    .withPageable(pageable)//从0页开始查，每页10个结果
                    .withFields("id","status","content","create_time","same_similar","modify_date")//ES里该index内存的文档，可能存了很多我们不关心的字段，全返回没必要，所以指定有用的字段
                    .withSort(sortBuilder)
                    .build();
//            scroll = (ScrolledPage<EmpiMiddleSearch>) elasticsearchTemplate.startScroll(SCROLL_TIMEOUT, searchQuery, EmpiMiddleSearch.class, searchResultMapper);
            scroll = (ScrolledPage<EmpiMiddleSearch>) elasticsearchTemplate.startScroll(SCROLL_TIMEOUT, searchQuery, EmpiMiddleSearch.class);
        }else{
//            scroll = (ScrolledPage<EmpiMiddleSearch>) elasticsearchTemplate.continueScroll(scrollId, SCROLL_TIMEOUT, EmpiMiddleSearch.class, searchResultMapper);
            scroll = (ScrolledPage<EmpiMiddleSearch>) elasticsearchTemplate.continueScroll(scrollId, SCROLL_TIMEOUT, EmpiMiddleSearch.class);
        }
        log.info("查询总命中数：{}" ,scroll.getTotalElements());
        //及时释放es服务器资源
        if(null==scroll.getContent() || scroll.isEmpty()){
            clearScroll(scroll.getScrollId());
        }

        return scroll;
    }

    /**
     * 用于将Scroll获取到的结果，处理成dto列表，做复杂映射
     */
    private final SearchResultMapper searchResultMapper = new SearchResultMapper() {
        @Override
        public <T> T mapSearchHit(SearchHit searchHit, Class<T> type) {
            return null;
        }
        @Override
        public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> aClass, Pageable pageable) {
            List<EmpiMiddleSearch> result = new ArrayList<>();
            for (SearchHit hit : response.getHits()) {
                if (response.getHits().getHits().length <= 0) {
                    return new AggregatedPageImpl<T>(Collections.EMPTY_LIST, pageable, response.getHits().getTotalHits(), response.getScrollId());
                }
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                result.add(new EmpiMiddleSearch());
            }
            if (result.isEmpty()) {
                return new AggregatedPageImpl<T>(Collections.EMPTY_LIST, pageable, response.getHits().getTotalHits(), response.getScrollId());
            }
            return new AggregatedPageImpl<T>((List<T>) result, pageable, response.getHits().getTotalHits(), response.getScrollId());
        }
    };

    @Override
    public String clearScroll(String scrollId) throws Exception {
        if(StringUtils.isEmpty(scrollId)){
            return "参数 scrollId 不能为空";
        }
        elasticsearchTemplate.clearScroll(scrollId);
        return "Clears the search contexts associated with specified scroll success";
    }
}
