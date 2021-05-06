package com.taiyangguo.springtemplate.config;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: cz
 * @Date: 2021/4/29
 * @Description:
 */
@Configuration
public class PrestoJdbcConfig {

    @Autowired
    private DbConnectionFactory factory;

    @Bean(name = "prestoJdbcPool")
    public GenericObjectPool<PrestoJdbc> prestoJdbcPool() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(3);
        poolConfig.setMinIdle(1);
        poolConfig.setMaxTotal(5);
        poolConfig.setJmxEnabled(false);
        return new GenericObjectPool<>(factory, poolConfig);
    }

}
