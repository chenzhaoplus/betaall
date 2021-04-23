package com.taiyangguo.testspring.enums.strategy;

import com.taiyangguo.testspring.service.EnumCommon;
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
    public String eat() {
        return "吃竹子";
    }
}
