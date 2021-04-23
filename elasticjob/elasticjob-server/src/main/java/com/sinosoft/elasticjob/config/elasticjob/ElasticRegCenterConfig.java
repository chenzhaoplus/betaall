package com.sinosoft.elasticjob.config.elasticjob;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticRegCenterConfig {

    @Autowired
    private ElasticJobProperties properties;

    /**
     * 配置zookeeper
     * @param serverList
     * @param namespace
     * @return
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter() {
        String serverList = properties.getServerList();
        String namespace = properties.getNamespace();
        ZookeeperConfiguration zkConfig = new ZookeeperConfiguration(serverList, namespace);
        return new ZookeeperRegistryCenter(zkConfig);
    }
}
