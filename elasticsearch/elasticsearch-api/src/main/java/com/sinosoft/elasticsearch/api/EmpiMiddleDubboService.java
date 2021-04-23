package com.sinosoft.elasticsearch.api;

import com.sinosoft.elasticsearch.model.EmpiMiddleSearchDto;
import com.sinosoft.elasticsearch.model.ReturnDataInfo;
import com.sinosoft.elasticsearch.model.ScrollSearchDto;

import java.util.List;

public interface EmpiMiddleDubboService {

    ReturnDataInfo<EmpiMiddleSearchDto> searchAllPage(Integer page,Integer pageSize) throws Exception;

    ReturnDataInfo<EmpiMiddleSearchDto> searchAll() throws Exception;

    ReturnDataInfo<ScrollSearchDto<EmpiMiddleSearchDto>> searchAllScrollPage(Integer page, Integer pageSize, String scrollId) throws Exception;
    ReturnDataInfo<String> clearScroll(String scrollId) throws Exception;

}
