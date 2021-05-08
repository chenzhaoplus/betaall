package com.taiyangguo.handlerChain.service.impl;

import com.taiyangguo.handlerChain.entity.HandlerContext;
import com.taiyangguo.handlerChain.entity.HandlerReturn;
import com.taiyangguo.handlerChain.service.HandlerChain;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class FirstHandler extends HandlerChain {

    @Override
    public HandlerReturn check(HandlerContext ctx) {
        return new HandlerReturn("1", false);
    }

}
