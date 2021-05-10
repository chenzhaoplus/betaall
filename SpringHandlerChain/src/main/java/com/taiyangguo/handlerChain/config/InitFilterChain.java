package com.taiyangguo.handlerChain.config;

import com.taiyangguo.handlerChain.entity.Study;
import com.taiyangguo.handlerChain.service.HandlerChain;
import com.taiyangguo.handlerChain.service.StudyPrepareFilter;
import com.taiyangguo.handlerChain.service.impl.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 参考：
 * https://www.toutiao.com/i6790678642474091022/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1620575442&app=news_article&utm_source=weixin&utm_medium=toutiao_android&use_new_style=1&req_id=202105092350410102122020930377C265&share_token=cc5df53a-6230-4d26-baba-61d52a3ee1cc&group_id=6790678642474091022&wid=1620608829572
 */
@Configuration
public class InitFilterChain {
    @Autowired
    private BeanFactory beanFactory;

    /**
     * 自定义责任链
     *
     * @return
     */
    @Bean(name = "customFilter")
    public FilterChain customFilter() {
        return initNextHandler(WashFaceFilter.class, WashHairFilter.class, HaveBreakfastFilter.class);
    }

    @Bean(name = "customFilter2")
    public FilterChain customFilter2() {
        return initNextHandler(WashHairFilter.class, HaveBreakfastFilter.class);
    }

    private FilterChain initNextHandler(Class... klasses) {
        if(klasses.length <= 0){
            return null;
        }

        FilterChain chains = new FilterChain(new Study());
        for (Class<StudyPrepareFilter> clazz : klasses) {
            chains.addFilter(beanFactory.getBean(clazz));
        }

        return chains;
    }

    private String getLowerClazzName(Class clazz) {
        String className = clazz.getSimpleName();
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

}
