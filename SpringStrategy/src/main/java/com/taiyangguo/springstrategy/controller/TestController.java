package com.taiyangguo.springstrategy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cz
 * @Date: 2021/4/23
 * @Description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping(value = "/sendMessage")
    public String sendMessage() throws Exception {
        log.info("[test success]");
        return "success";
    }

}
