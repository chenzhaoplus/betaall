package com.sinosoft.elasticjob.boot.service.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.sinosoft.elasticjob.boot.service.ITEmpiMiddleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步 t_empi 表数据到 t_empi_middle 表
 */
@Component
@Slf4j
public class EmpiMiddleJob implements SimpleJob {

    @Autowired
    private ITEmpiMiddleService itEmpiMiddleService;

    @Override
    public void execute(ShardingContext shardingContext) {
        
    }

}
