package com.sinosoft.elasticsearch.boot.service;

import com.sinosoft.elasticsearch.boot.entity.EmpiMiddleSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ScrolledPage;

import java.util.List;

public interface EmpiMiddleSearchService  {

    Page<EmpiMiddleSearch> testSearch() throws Exception;

    Page<EmpiMiddleSearch> testSearchPage(int page, int pageSize) throws Exception;

    Page<EmpiMiddleSearch> searchAllPage(int page, int pageSize) throws Exception;

    List<EmpiMiddleSearch> searchAll() throws Exception;

    ScrolledPage<EmpiMiddleSearch> searchAllScrollPage(int page, int pageSize, String scrollId) throws Exception;
    String clearScroll(String scrollId) throws Exception;

}
