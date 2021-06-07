package com.taiyangguo.springtemplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @Autowired
    private RedissonClient redissonClient;

    private static Integer num = 1;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(String lockName, boolean clear) throws Exception {
        log.info("[test success]");
        if(clear){
            num = 1;
        }
        if (StringUtils.isEmpty(lockName)) {
            lockName = "test";
        }

        RLock lock = redissonClient.getLock(lockName);
        try {
            lock.lock();
            log.info("lock num = {}", num++);
        } finally {
            lock.unlock();
        }

        return "success";
    }

}
