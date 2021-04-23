package com.sinosoft.elasticsearch.boot.controller;

import com.sinosoft.elasticsearch.model.ReturnDataInfo;
import com.sinosoft.elasticsearch.boot.entity.MdBaseDrug;
import com.sinosoft.elasticsearch.boot.service.MdBaseDrugService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sinosoft
 * @since 2020-04-25
 */
@Controller
@RequestMapping("/mdBaseDrug")
@Slf4j
public class MdBaseDrugController {
    @Autowired
    private MdBaseDrugService mdBaseDrugService;

    @ApiOperation("测试")
    @PostMapping(value = "/test")
    @ResponseBody
    public ReturnDataInfo<List<MdBaseDrug>> test(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<MdBaseDrug> appDoctor = mdBaseDrugService.test("29797");
        return ReturnDataInfo.createSuccessfulSingleExecuteResult(appDoctor);
    }

}

