package com.taiyangguo.handlerChain.service.impl;

import com.taiyangguo.handlerChain.entity.HandlerContext;
import com.taiyangguo.handlerChain.entity.HandlerReturn;
import com.taiyangguo.handlerChain.service.HandlerChain;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class SecondHandler extends HandlerChain {

    @Override
    public HandlerReturn action(HandlerContext ctx) {
        System.out.println("SecondHandler, info = " + ctx.getInfo());
        return new HandlerReturn("SecondHandler action", false);
    }

}
