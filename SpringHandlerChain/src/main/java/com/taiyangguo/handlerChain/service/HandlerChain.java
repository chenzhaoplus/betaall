package com.taiyangguo.handlerChain.service;

import com.taiyangguo.handlerChain.entity.HandlerContext;
import com.taiyangguo.handlerChain.entity.HandlerReturn;
import lombok.Data;

import java.util.Objects;

@Data
public abstract class HandlerChain {

    private HandlerChain nextHandler;

    /**
     * 执行控制方法
     *
     * @param ctx
     * @return
     */
    public HandlerReturn handler(HandlerContext ctx) {
        HandlerReturn result = action(ctx);
        if(Objects.nonNull(nextHandler)){
            return nextHandler.handler(ctx);
        }
        return result;
    }

    /**
     * 实际校验逻辑
     *
     * @param ctx
     * @return
     */
    public abstract HandlerReturn action(HandlerContext ctx);

}
