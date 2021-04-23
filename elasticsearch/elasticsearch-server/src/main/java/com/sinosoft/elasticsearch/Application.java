package com.sinosoft.elasticsearch;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@ComponentScan
@MapperScan("com.sinosoft.elasticsearch.**.mapper*")
@ServletComponentScan(basePackages = "com.sinosoft.elasticsearch")
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");// 没有此行代码，启动会报找不到 es client 的错误
        SpringApplication.run(Application.class, args);
    }
}
