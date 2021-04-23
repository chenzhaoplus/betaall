package com.sinosoft.elasticjob.boot.service;

import com.sinosoft.elasticjob.boot.entity.MdBaseDrug;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * MD医疗机构药品基本资料 服务类
 * </p>
 *
 * @author sinosoft
 * @since 2020-04-25
 */
public interface MdBaseDrugService extends IService<MdBaseDrug> {

    public List<MdBaseDrug> test(String mCode) throws Exception;

}
