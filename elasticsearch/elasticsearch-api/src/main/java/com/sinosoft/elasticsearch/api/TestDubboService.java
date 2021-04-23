package com.sinosoft.elasticsearch.api;

import com.sinosoft.elasticsearch.model.ReturnDataInfo;

public interface TestDubboService {

    public ReturnDataInfo<String> test1() throws Exception;
}
