package com.sinosoft.elasticjob.config.elasticjob;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class MyElasticJobListener implements ElasticJobListener {
    private long beginTime = 0;
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        log.info("===>{} JOB BEGIN TIME: {} <===",shardingContexts.getJobName(), new Date());
    }
    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        log.info("===>{} JOB END TIME: {},TOTAL CAST: {} <===",shardingContexts.getJobName(), new Date());
    }
}
