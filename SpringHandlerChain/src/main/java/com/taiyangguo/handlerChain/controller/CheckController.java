package com.taiyangguo.handlerChain.controller;

import com.taiyangguo.handlerChain.entity.HandlerContext;
import com.taiyangguo.handlerChain.entity.HandlerReturn;
import com.taiyangguo.handlerChain.entity.PreparationList;
import com.taiyangguo.handlerChain.entity.Study;
import com.taiyangguo.handlerChain.service.HandlerChain;
import com.taiyangguo.handlerChain.service.StudyPrepareFilter;
import com.taiyangguo.handlerChain.service.impl.FilterChain;
import com.taiyangguo.handlerChain.service.impl.HaveBreakfastFilter;
import com.taiyangguo.handlerChain.service.impl.WashFaceFilter;
import com.taiyangguo.handlerChain.service.impl.WashHairFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Filter;

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
    @Autowired
    @Qualifier("customFilter")
    private FilterChain customFilter;
    @Autowired
    @Qualifier("customFilter2")
    private FilterChain customFilter2;

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

    /**
     * http://localhost:8088/handler/custom3
     * @return
     */
    @RequestMapping("/custom3")
    public void custom3() {
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(false);
        preparationList.setHaveBreakfast(true);

//        FilterChain filterChain = new FilterChain(new Study());
//        filterChain.addFilter(new WashFaceFilter());
//        filterChain.addFilter(new WashHairFilter());
//        filterChain.addFilter(new HaveBreakfastFilter());

        customFilter.doFilter(preparationList, customFilter);
        System.out.println("--------------------------------------");
        customFilter2.doFilter(preparationList, customFilter2);
    }

}
