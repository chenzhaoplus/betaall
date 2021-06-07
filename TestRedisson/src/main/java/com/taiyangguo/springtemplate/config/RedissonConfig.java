package com.taiyangguo.springtemplate.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.cluster.nodes}")
    private List<String> nodes;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        ClusterServersConfig clusterConfig = config.useClusterServers().setScanInterval(2000);
        clusterConfig.setPassword(password);
        if (!CollectionUtils.isEmpty(nodes)) {
            nodes.forEach(addr -> clusterConfig.addNodeAddress("redis://" + addr));
        }

        RedissonClient redisson = Redisson.create(config);

        return redisson;
    }

}
