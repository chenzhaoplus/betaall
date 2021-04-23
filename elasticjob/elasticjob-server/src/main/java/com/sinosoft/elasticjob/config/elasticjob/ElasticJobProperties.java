package com.sinosoft.elasticjob.config.elasticjob;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "elasticjob")
public class ElasticJobProperties {

    private String serverList;
    private String namespace;
    private int shardingTotalCount;
    private String shardingItemParameters;
    private String simpleJobCron;
    private String empiMiddleJobCron;

}
