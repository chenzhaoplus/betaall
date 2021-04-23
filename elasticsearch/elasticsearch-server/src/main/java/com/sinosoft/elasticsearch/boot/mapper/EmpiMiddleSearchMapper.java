package com.sinosoft.elasticsearch.boot.mapper;

import com.sinosoft.elasticsearch.boot.entity.EmpiMiddleSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpiMiddleSearchMapper extends ElasticsearchRepository<EmpiMiddleSearch, String> {

}
