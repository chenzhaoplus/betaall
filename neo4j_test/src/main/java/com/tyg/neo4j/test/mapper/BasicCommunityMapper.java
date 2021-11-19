package com.tyg.neo4j.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: cz
 * @Date: 2021/11/8
 * @Description:
 */
@Mapper
public interface BasicCommunityMapper {

    void loadCommunity(@Param("jdbcSql") String jdbcSql);

    List findCommunity();

}
