package com.taiyangguo.springtemplate.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenz
 */
@Configuration
@EnableConfigurationProperties({PrestoJdbcProperties.class, FaceLibConfigProperties.class})
public class PersonConfiguration {

}
