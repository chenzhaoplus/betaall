package com.taiyangguo.springtemplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
    public Integer sendMessage(String lockName, boolean clear) throws Exception {
        log.info("[test success]");
        if(clear){
            num = 1;
        }
        if (StringUtils.isEmpty(lockName)) {
            lockName = "test";
        }

        RLock lock = redissonClient.getLock("anyLock");
        try{
            // 1. 最常见的使用方法
            //lock.lock();

            // 2. 支持过期解锁功能,10秒钟以后自动解锁, 无需调用unlock方法手动解锁
            //lock.lock(10, TimeUnit.SECONDS);

            // 3. 尝试加锁，最多等待3秒，上锁以后10秒自动解锁
            boolean res = lock.tryLock(3, 10, TimeUnit.SECONDS);
            if(res){
                //成功
                // do your business
                log.info("lock num = {}", num++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return num;
    }

}
