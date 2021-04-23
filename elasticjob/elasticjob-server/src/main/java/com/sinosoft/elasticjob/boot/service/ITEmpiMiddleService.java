package com.sinosoft.elasticjob.boot.service;

import com.sinosoft.elasticjob.boot.entity.TEmpiMiddle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sinosoft
 * @since 2020-05-08
 */
public interface ITEmpiMiddleService extends IService<TEmpiMiddle> {

    void syncEmpiToMiddle() throws Exception;

}
