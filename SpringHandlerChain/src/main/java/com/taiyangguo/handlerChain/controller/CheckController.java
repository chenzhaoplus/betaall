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

//    @Autowired
//    @Qualifier("initHandler")
//    private HandlerChain initHandler;
    @Autowired
    @Qualifier("customHandler")
    private HandlerChain customHandler;
    @Autowired
    @Qualifier("customHandler2")
    private HandlerChain customHandler2;

    /**
     * http://localhost:8088/handler/init
     * @return
     */
//    @RequestMapping("/init")
//    public HandlerReturn check() {
//        HandlerContext ctx = new HandlerContext();
//        ctx.setInfo("this is info");
//        HandlerReturn handler = initHandler.handler(ctx);
//        return handler;
//    }

    /**
     * http://localhost:8088/handler/custom
     * @return
     */
    @RequestMapping("/custom")
    public HandlerReturn custom() {
        HandlerContext ctx = new HandlerContext();
        ctx.setInfo("this is info");
        HandlerReturn handler = customHandler.handler(ctx);
        return handler;
    }

    /**
     * http://localhost:8088/handler/custom2
     * @return
     */
    @RequestMapping("/custom2")
    public HandlerReturn custom2() {
        HandlerContext ctx = new HandlerContext();
        ctx.setInfo("this is info");
        HandlerReturn handler = customHandler2.handler(ctx);
        return handler;
    }

}
