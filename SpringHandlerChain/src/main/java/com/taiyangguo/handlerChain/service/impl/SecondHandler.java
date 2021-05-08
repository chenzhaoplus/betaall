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
    public HandlerReturn check(HandlerContext ctx) {
        return new HandlerReturn("2", true);
    }

}
