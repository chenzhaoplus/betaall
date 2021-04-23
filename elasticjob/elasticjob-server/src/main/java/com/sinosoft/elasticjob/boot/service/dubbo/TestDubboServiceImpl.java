package com.sinosoft.elasticjob.boot.service.dubbo;

import com.sinosoft.elasticjob.model.ReturnDataInfo;
import com.sinosoft.elasticjob.api.TestDubboService;
import com.sinosoft.elasticjob.boot.entity.MdBaseDrug;
import com.sinosoft.elasticjob.boot.service.MdBaseDrugService;
import com.sinosoft.elasticjob.utils.GsonUtils;
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
