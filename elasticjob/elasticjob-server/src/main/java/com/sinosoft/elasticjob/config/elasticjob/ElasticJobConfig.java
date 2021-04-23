package com.sinosoft.elasticjob.config.elasticjob;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.sinosoft.elasticjob.boot.service.job.EmpiMiddleJob;
import com.sinosoft.elasticjob.boot.service.job.SimpleJobDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticJobConfig {
    @Autowired
    private ZookeeperRegistryCenter regCenter;
    @Autowired
    private ElasticJobProperties properties;

    /**
     * 配置任务监听器
     * @return
     */
    @Bean
    public ElasticJobListener elasticJobListener() {
        return new MyElasticJobListener();
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SimpleJobDemo simpleJob) {
        String cron = properties.getSimpleJobCron();
        int shardingTotalCount = properties.getShardingTotalCount();
        String shardingItemParameters = properties.getShardingItemParameters();
        MyElasticJobListener elasticJobListener = new MyElasticJobListener();
        LiteJobConfiguration liteJobConfiguration = getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters);
        SpringJobScheduler springJobScheduler = new SpringJobScheduler(simpleJob, regCenter,liteJobConfiguration,elasticJobListener);
        return springJobScheduler;
    }
    @Bean(initMethod = "init")
    public JobScheduler empiMiddleJobScheduler(final EmpiMiddleJob simpleJob) {
        String cron = properties.getEmpiMiddleJobCron();
        int shardingTotalCount = properties.getShardingTotalCount();
        String shardingItemParameters = properties.getShardingItemParameters();
        MyElasticJobListener elasticJobListener = new MyElasticJobListener();
        LiteJobConfiguration liteJobConfiguration = getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters);
        SpringJobScheduler springJobScheduler = new SpringJobScheduler(simpleJob, regCenter,liteJobConfiguration,elasticJobListener);
        return springJobScheduler;
    }

    /**
     * 配置任务详细信息
     * @param jobClass
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     * @return
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {
        JobCoreConfiguration.Builder builder = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount);
        JobCoreConfiguration coreConfig = builder.shardingItemParameters(shardingItemParameters).build();
        SimpleJobConfiguration jobConfig = new SimpleJobConfiguration(coreConfig, jobClass.getCanonicalName());
        return LiteJobConfiguration.newBuilder(jobConfig).overwrite(true).build();
    }

}