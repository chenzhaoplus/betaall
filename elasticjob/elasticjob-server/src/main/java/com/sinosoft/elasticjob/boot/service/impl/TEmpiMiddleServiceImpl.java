package com.sinosoft.elasticjob.boot.service.impl;

import com.sinosoft.elasticjob.boot.entity.TEmpiMiddle;
import com.sinosoft.elasticjob.boot.mapper.TEmpiMiddleMapper;
import com.sinosoft.elasticjob.boot.service.ITEmpiMiddleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sinosoft
 * @since 2020-05-08
 */
@Service
public class TEmpiMiddleServiceImpl extends ServiceImpl<TEmpiMiddleMapper, TEmpiMiddle> implements ITEmpiMiddleService {
    @Autowired
    private TEmpiMiddleMapper empiMiddleMapper;

    @Override
    public void syncEmpiToMiddle() throws Exception {

    }

}
