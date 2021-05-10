package com.taiyangguo.handlerChain.service.impl;

import com.taiyangguo.handlerChain.entity.HandlerContext;
import com.taiyangguo.handlerChain.entity.HandlerReturn;
import com.taiyangguo.handlerChain.service.HandlerChain;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ThirdHandler extends HandlerChain {

    @Override
    public HandlerReturn action(HandlerContext ctx) {
        System.out.println("ThirdHandler, info = " + ctx.getInfo());
        return new HandlerReturn("ThirdHandler action");
    }

}
