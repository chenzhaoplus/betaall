package com.taiyangguo.handlerChain.config;

import com.taiyangguo.handlerChain.service.HandlerChain;
import com.taiyangguo.handlerChain.service.impl.FirstHandler;
import com.taiyangguo.handlerChain.service.impl.ThirdHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class InitHandlerChain {
    @Autowired
    List<HandlerChain> handlerChains;
    @Autowired
    private Map<String, HandlerChain> handlerChainMap;

    /**
     * 全量按顺序责任链
     * @return
     */
    @Bean(name = "initHandler")
    public HandlerChain initHandler() {
        int size = handlerChains.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                handlerChains.get(i).setNextHandler(null);
            } else {
                handlerChains.get(i).setNextHandler(handlerChains.get(i + 1));
            }
        }
        return handlerChains.get(0);
    }

    /**
     * 自定义责任链
     * @return
     */
    @Bean(name = "customHandler")
    public HandlerChain customHandler() {
        HandlerChain firstHandler = handlerChainMap.get(getLowerClazzName(FirstHandler.class));
        firstHandler.setNextHandler(handlerChainMap.get(getLowerClazzName(ThirdHandler.class)));
        return firstHandler;
    }

    private String getLowerClazzName(Class clazz) {
        String className = clazz.getSimpleName();
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

}
