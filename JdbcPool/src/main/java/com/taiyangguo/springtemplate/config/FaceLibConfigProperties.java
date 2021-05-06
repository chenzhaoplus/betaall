package com.taiyangguo.springtemplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = FaceLibConfigProperties.FACELIB)
public class FaceLibConfigProperties {
    public static final String FACELIB = "facelib";
    private Long expireTime;
    /**
     * 陌生人频繁出现次数阈值
     */
    private Integer leastCnt;
    /**
     * 陌生人频繁出现月份阈值
     */
    private Integer leastMonthCnt;
}

