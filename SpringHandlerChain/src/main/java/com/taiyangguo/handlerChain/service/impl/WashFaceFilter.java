package com.taiyangguo.handlerChain.service.impl;

import com.taiyangguo.handlerChain.entity.PreparationList;
import com.taiyangguo.handlerChain.service.StudyPrepareFilter;
import org.springframework.stereotype.Component;

@Component
public class WashFaceFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashFace()) {
            System.out.println("洗完脸");
        }

        filterChain.doFilter(preparationList, filterChain);
    }

}
