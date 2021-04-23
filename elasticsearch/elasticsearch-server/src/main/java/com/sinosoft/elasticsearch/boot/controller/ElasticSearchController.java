package com.sinosoft.elasticsearch.boot.controller;

import com.sinosoft.elasticsearch.model.ReturnDataInfo;
import com.sinosoft.elasticsearch.boot.entity.EmpiMiddleSearch;
import com.sinosoft.elasticsearch.boot.service.EmpiMiddleSearchService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sinosoft
 * @since 2020-04-25
 */
@Controller
@RequestMapping("/elasticsearch")
@Slf4j
public class ElasticSearchController {
    @Autowired
    private EmpiMiddleSearchService empiMiddleSearchService;

    @ApiOperation("测试搜索")
    @PostMapping(value = "/testSearch")
    @ResponseBody
    public ReturnDataInfo<EmpiMiddleSearch> testSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Page<EmpiMiddleSearch> page = empiMiddleSearchService.testSearch();
        List<EmpiMiddleSearch> list = page.getContent();
        Long current = Long.valueOf(page.getNumber());
        Long pageSize = Long.valueOf(page.getSize());
        Long totalElements = page.getTotalElements();
        return ReturnDataInfo.createSuccessfulExecuteResults(list,current,pageSize, totalElements);
    }

    @ApiOperation("搜索分页")
    @PostMapping(value = "/searchPage")
    @ResponseBody
    public ReturnDataInfo<EmpiMiddleSearch> searchPage(HttpServletRequest request, HttpServletResponse response,
                                                       @RequestParam(value = "page")int page,
                                                       @RequestParam(value = "pageSize")int pageSize) throws Exception{
        Page<EmpiMiddleSearch> pageList = empiMiddleSearchService.testSearchPage(page,pageSize);
        List<EmpiMiddleSearch> list = pageList.getContent();
        Long totalElements = pageList.getTotalElements();
        return ReturnDataInfo.createSuccessfulExecuteResults(list,Long.valueOf(page),Long.valueOf(pageSize), totalElements);
    }

}

