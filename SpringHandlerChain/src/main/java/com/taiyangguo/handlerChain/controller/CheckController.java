package com.taiyangguo.handlerChain.controller;

import com.taiyangguo.handlerChain.entity.HandlerContext;
import com.taiyangguo.handlerChain.entity.HandlerReturn;
import com.taiyangguo.handlerChain.service.HandlerChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/handler")
public class CheckController {

    @Autowired
    @Qualifier("initHandler")
    private HandlerChain initHandler;

    @RequestMapping("/check")
    public HandlerReturn check() {
        HandlerContext ctx = new HandlerContext();
        ctx.setInfo("this is info");
        HandlerReturn handler = initHandler.handler(ctx);
        return handler;
    }

}
