package com.taiyangguo.handlerChain.service.impl;

import com.taiyangguo.handlerChain.entity.PreparationList;
import com.taiyangguo.handlerChain.service.StudyPrepareFilter;
import org.springframework.stereotype.Component;

@Component
public class HaveBreakfastFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃完早饭");
        }

        filterChain.doFilter(preparationList, filterChain);
    }

}
