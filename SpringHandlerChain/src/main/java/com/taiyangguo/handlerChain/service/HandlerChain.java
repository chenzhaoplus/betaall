package com.taiyangguo.handlerChain.service;

import com.taiyangguo.handlerChain.entity.HandlerContext;
import com.taiyangguo.handlerChain.entity.HandlerReturn;
import lombok.Data;

@Data
public abstract class HandlerChain {

    private HandlerChain nextHandler;

    /**
     * 执行控制方法
     *
     * @param person
     * @return
     */
    public HandlerReturn handler(HandlerContext ctx) {
        HandlerReturn result = check(ctx);
        if (!result.isOver()) {
            return nextHandler.handler(ctx);
        }
        return result;
    }

    /**
     * 实际校验逻辑
     *
     * @param person
     * @return
     */
    public abstract HandlerReturn check(HandlerContext ctx);

}
