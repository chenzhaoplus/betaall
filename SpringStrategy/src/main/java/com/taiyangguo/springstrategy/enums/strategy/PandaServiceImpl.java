package com.taiyangguo.springstrategy.enums.strategy;

import com.taiyangguo.springstrategy.service.EnumCommon;
import org.springframework.stereotype.Service;

/**
 * @Author: cz
 * @Date: 2021/4/23
 * @Description:
 */
@Service
public class PandaServiceImpl implements EnumCommon {
    /**
     * 吃
     *
     * @return
     */
    @Override
    public String action() {
        return "吃竹子";
    }
}
