package com.sinosoft.elasticsearch.boot.service.dubbo;

import com.sinosoft.elasticsearch.model.ReturnDataInfo;
import com.sinosoft.elasticsearch.api.TestDubboService;
import com.sinosoft.elasticsearch.boot.entity.MdBaseDrug;
import com.sinosoft.elasticsearch.boot.service.MdBaseDrugService;
import com.sinosoft.elasticsearch.utils.GsonUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TestDubboServiceImpl implements TestDubboService {
    @Autowired
    private MdBaseDrugService mdBaseDrugService;

    @Override
    public ReturnDataInfo<String> test1() throws Exception {
        List<MdBaseDrug> test = mdBaseDrugService.test("29797");
        String retStr = GsonUtils.toJson(test);
        return ReturnDataInfo.createSuccessfulSingleExecuteResult(retStr);
    }
}
