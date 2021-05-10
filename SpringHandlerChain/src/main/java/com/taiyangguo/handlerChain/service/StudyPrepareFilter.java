package com.taiyangguo.handlerChain.service;

import com.taiyangguo.handlerChain.entity.PreparationList;
import com.taiyangguo.handlerChain.service.impl.FilterChain;

public interface StudyPrepareFilter {

    public void doFilter(PreparationList preparationList, FilterChain filterChain);

}
