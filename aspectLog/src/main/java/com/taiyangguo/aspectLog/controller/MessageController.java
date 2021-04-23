package com.taiyangguo.aspectLog.controller;

import com.taiyangguo.aspectLog.config.TestLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageController {

    @GetMapping(value="/sendMessage",produces = "text/json;charset=UTF-8")
    public VodViewLog sendMessage(@RequestParam("param1") String param1,@RequestParam("param2") String param2) throws Exception {
//        try{
//        log.info("执行了controller.send_message方法");
//            int i = 1/0;
        VodViewLog vodViewLog = new VodViewLog();
        vodViewLog.setId(1);
        vodViewLog.setDr(0);
        vodViewLog.setUserId("2");
        return vodViewLog;
//        }catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }
    }

}
