package com.taiyangguo.handlerChain.service.impl;

import com.taiyangguo.handlerChain.entity.PreparationList;
import com.taiyangguo.handlerChain.entity.Study;
import com.taiyangguo.handlerChain.service.StudyPrepareFilter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("prototype")
public class FilterChain implements StudyPrepareFilter {
    private int pos = 0;
    private Study study;

    private List<StudyPrepareFilter> studyPrepareFilterList;

    public FilterChain(Study study) {
        this.study = study;
    }

    public void addFilter(StudyPrepareFilter studyPrepareFilter) {
        if (studyPrepareFilterList == null) {
            studyPrepareFilterList = new ArrayList<StudyPrepareFilter>();
        }

        studyPrepareFilterList.add(studyPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList thingList, FilterChain filterChain) {
        // 所有过滤器执行完毕
        if (pos == studyPrepareFilterList.size()) {
            study.study();
            return;
        }

        studyPrepareFilterList.get(pos++).doFilter(thingList, filterChain);
    }

}
