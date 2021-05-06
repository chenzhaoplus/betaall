package com.taiyangguo.springtemplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@Configuration
@ConfigurationProperties(prefix = PrestoJdbcProperties.JDBCPROP)
@Data
public class PrestoJdbcProperties {
    public static final String JDBCPROP = "presto.datasource";

    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
}

