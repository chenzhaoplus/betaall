package com.taiyangguo.handlerChain.config;

import com.taiyangguo.handlerChain.service.HandlerChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitHandlerChain {
    @Autowired
    List<HandlerChain> handlerChains;

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

}
