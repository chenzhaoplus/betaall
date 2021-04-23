package com.sinosoft.elasticsearch.boot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.reflect.TypeToken;
import com.sinosoft.elasticsearch.boot.entity.MdBaseDrug;
import com.sinosoft.elasticsearch.boot.mapper.MdBaseDrugMapper;
import com.sinosoft.elasticsearch.boot.service.MdBaseDrugService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.elasticsearch.utils.GsonUtils;
import com.sinosoft.elasticsearch.utils.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * MD医疗机构药品基本资料 服务实现类
 * </p>
 *
 * @author sinosoft
 * @since 2020-04-25
 */
@Service
public class MdBaseDrugServiceImpl extends ServiceImpl<MdBaseDrugMapper, MdBaseDrug> implements MdBaseDrugService {
    @Autowired
    private MdBaseDrugMapper mdBaseDrugMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public List<MdBaseDrug> test(String mCode) throws Exception{
        List<MdBaseDrug> test = mdBaseDrugMapper.test1(mCode);
        int page=1;
        int pageSize=10;
        Page<MdBaseDrug> pg = new Page<>(page,pageSize);
        List<MdBaseDrug> mdBaseDrugs = mdBaseDrugMapper.testPage(pg);
        pg.setRecords(mdBaseDrugs);
        String redisKey = mCode + "_drug";
        boolean set = redisService.set(redisKey, GsonUtils.toJson(test));
        Object o = redisService.get(redisKey);
        if(o!=null && StringUtils.isNotBlank(o.toString())){
            List<MdBaseDrug> list = GsonUtils.fromJson(o.toString(), new TypeToken<List<MdBaseDrug>>(){}.getType());
            System.out.println(list);
        }
        return test;
    }
}
