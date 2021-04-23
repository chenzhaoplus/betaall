package com.sinosoft.elasticsearch.boot.service.dubbo;

import com.google.gson.reflect.TypeToken;
import com.sinosoft.elasticsearch.api.EmpiMiddleDubboService;
import com.sinosoft.elasticsearch.boot.entity.EmpiMiddleSearch;
import com.sinosoft.elasticsearch.boot.service.EmpiMiddleSearchService;
import com.sinosoft.elasticsearch.model.EmpiMiddleSearchDto;
import com.sinosoft.elasticsearch.model.ReturnDataInfo;
import com.sinosoft.elasticsearch.model.ScrollSearchDto;
import com.sinosoft.elasticsearch.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ScrolledPage;

import java.util.List;

@Service(timeout = 60000, retries = 0)
//@Service
@Slf4j
public class EmpiMiddleDubboServiceImpl implements EmpiMiddleDubboService {
    @Autowired
    private EmpiMiddleSearchService empiMiddleSearchService;

    @Override
    public ReturnDataInfo<EmpiMiddleSearchDto> searchAllPage(Integer page,Integer pageSize) throws Exception {
        if(page==null){
            page=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        Page<EmpiMiddleSearch> pageList = empiMiddleSearchService.searchAllPage(page,pageSize);

        List<EmpiMiddleSearch> list = pageList.getContent();
        String listJson = GsonUtils.toJson(list);
        List<EmpiMiddleSearchDto> dtoList = GsonUtils.fromJson(listJson, new TypeToken<List<EmpiMiddleSearchDto>>(){}.getType());
        Long totalElements = pageList.getTotalElements();

        ReturnDataInfo<EmpiMiddleSearchDto> returnDataInfo = ReturnDataInfo.createSuccessfulExecuteResults(dtoList, Long.valueOf(page), Long.valueOf(pageSize), totalElements);
        return returnDataInfo;
    }

    @Override
    public ReturnDataInfo<EmpiMiddleSearchDto> searchAll() throws Exception {
        List<EmpiMiddleSearch> list = empiMiddleSearchService.searchAll();

        String listJson = GsonUtils.toJson(list);
        List<EmpiMiddleSearchDto> dtoList = GsonUtils.fromJson(listJson, new TypeToken<List<EmpiMiddleSearchDto>>(){}.getType());

        ReturnDataInfo<EmpiMiddleSearchDto> returnDataInfo = ReturnDataInfo.createSuccessfulExecuteResults(dtoList);
        return returnDataInfo;
    }

    @Override
    public ReturnDataInfo<ScrollSearchDto<EmpiMiddleSearchDto>> searchAllScrollPage(Integer page, Integer pageSize, String scrollId) throws Exception {
        if(StringUtils.isEmpty(scrollId)){
            if(page==null || page>1){
                page=1;
            }
            if(pageSize==null){
                pageSize=10;
            }
        }
        ScrolledPage<EmpiMiddleSearch> pg = empiMiddleSearchService.searchAllScrollPage(page,pageSize,scrollId);

        List<EmpiMiddleSearch> list = pg.getContent();
        String listJson = GsonUtils.toJson(list);
        List<EmpiMiddleSearchDto> dtoList = GsonUtils.fromJson(listJson, new TypeToken<List<EmpiMiddleSearchDto>>(){}.getType());
        Long totalElements = pg.getTotalElements();

        ScrollSearchDto<EmpiMiddleSearchDto> scrollSearchDto = new ScrollSearchDto<EmpiMiddleSearchDto>();
        scrollSearchDto.setContentList(dtoList);
        scrollSearchDto.setScrollId(pg.getScrollId());
        scrollSearchDto.setPage(Long.valueOf(page));
        scrollSearchDto.setPageSize(Long.valueOf(pageSize));
        scrollSearchDto.setTotalElements(totalElements);

        ReturnDataInfo<ScrollSearchDto<EmpiMiddleSearchDto>> returnDataInfo = ReturnDataInfo.createSuccessfulSingleExecuteResult(scrollSearchDto);
        return returnDataInfo;
    }

    @Override
    public ReturnDataInfo<String> clearScroll(String scrollId) throws Exception {
        String s = empiMiddleSearchService.clearScroll(scrollId);
        return ReturnDataInfo.createSuccessfulSingleExecuteResult(s);
    }
}
