package com.sinosoft.elasticjob.boot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sinosoft.elasticjob.boot.entity.MdBaseDrug;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * MD医疗机构药品基本资料 Mapper 接口
 * </p>
 *
 * @author sinosoft
 * @since 2020-04-25
 */
public interface MdBaseDrugMapper extends BaseMapper<MdBaseDrug> {

    List<MdBaseDrug> test1(@Param("mCode") String mCode);

    List<MdBaseDrug> testPage(Page<MdBaseDrug> pg);

}
