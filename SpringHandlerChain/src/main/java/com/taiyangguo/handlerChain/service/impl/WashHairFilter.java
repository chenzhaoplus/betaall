package com.taiyangguo.handlerChain.service.impl;

import com.taiyangguo.handlerChain.entity.PreparationList;
import com.taiyangguo.handlerChain.service.StudyPrepareFilter;
import org.springframework.stereotype.Component;

@Component
public class WashHairFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashHair()) {
            System.out.println("洗完头发");
        }

        filterChain.doFilter(preparationList, filterChain);
    }

}
