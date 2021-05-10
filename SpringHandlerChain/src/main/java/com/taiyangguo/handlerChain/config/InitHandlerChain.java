package com.taiyangguo.handlerChain.config;

import com.taiyangguo.handlerChain.service.HandlerChain;
import com.taiyangguo.handlerChain.service.impl.FirstHandler;
import com.taiyangguo.handlerChain.service.impl.SecondHandler;
import com.taiyangguo.handlerChain.service.impl.ThirdHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 参考：
 * https://my.oschina.net/u/269777/blog/4276963
 * https://www.toutiao.com/i6790678642474091022/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1620575442&app=news_article&utm_source=weixin&utm_medium=toutiao_android&use_new_style=1&req_id=202105092350410102122020930377C265&share_token=cc5df53a-6230-4d26-baba-61d52a3ee1cc&group_id=6790678642474091022&wid=1620608829572
 */
@Configuration
public class InitHandlerChain {
//    @Autowired
//    List<HandlerChain> handlerChains;
    @Autowired
    private BeanFactory beanFactory;
//    @Autowired
//    private Map<String, HandlerChain> handlerChainMap;

    /**
     * 全量按顺序责任链
     *
     * @return
     */
//    @Bean(name = "initHandler")
//    public HandlerChain initHandler() {
//        initNextHandler(handlerChains);
//        return handlerChains.get(0);
//    }

    /**
     * 自定义责任链
     *
     * @return
     */
    @Bean(name = "customHandler")
    public HandlerChain customHandler() {
        return initNextHandler(FirstHandler.class, ThirdHandler.class);
    }

    @Bean(name = "customHandler2")
    public HandlerChain customHandler2() {
        return initNextHandler(SecondHandler.class, ThirdHandler.class);
    }

    private HandlerChain initNextHandler(Class... klasses) {
        List chains = new ArrayList<>();
        for (Class clazz : klasses) {
            chains.add(beanFactory.getBean(clazz));
        }
        return initNextHandler(chains);
    }

    private HandlerChain initNextHandler(List<HandlerChain> chains) {
        int size = chains.size();
        HandlerChain firstHandler = null;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                chains.get(i).setNextHandler(null);
            } else {
                chains.get(i).setNextHandler(chains.get(i + 1));
            }
            if(i == 0){
                firstHandler = chains.get(0);
            }
        }
        return firstHandler;
    }

//    private void initNextHandler(Class... klasses) {
//        List<HandlerChain> chains = new ArrayList<>();
//        for (Class clazz : klasses) {
//            chains.add(handlerChainMap.get(getLowerClazzName(clazz)));
//        }
//        initNextHandler(chains);
//    }

    private String getLowerClazzName(Class clazz) {
        String className = clazz.getSimpleName();
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

}
