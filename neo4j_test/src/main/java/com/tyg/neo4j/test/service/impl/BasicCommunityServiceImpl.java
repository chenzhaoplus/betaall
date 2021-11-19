package com.tyg.neo4j.test.service.impl;

import com.tyg.neo4j.test.mapper.BasicCommunityMapper;
import com.tyg.neo4j.test.service.BasicCommunityService;
//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.Session;
//import org.neo4j.driver.v1.StatementResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: cz
 * @Date: 2021/11/8
 * @Description:
 */
@Service
public class BasicCommunityServiceImpl implements BasicCommunityService {

    @Autowired
    private BasicCommunityMapper communityMapper;

    //@Autowired
    //private Driver neo4jDriver;
    //public StatementResult excuteCypherSql(String cypherSql) {
    //    StatementResult result = null;
    //    try (Session session = neo4jDriver.session()) {
    //        result = session.run(cypherSql);
    //    } catch (Exception e) {
    //        throw e;
    //    }
    //    return result;
    //}

    @Override
    public List loadCommunity() {
        //StringBuilder apocSql = new StringBuilder();
        //apocSql.append("CALL apoc.load.jdbc('jdbc:mysql://172.16.4.83:3306/ibmp?user=ibmp_test&password=XZdfjXIEsrumGrfFTmfltbtAuQCECUdl&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC', 'select * from zz_school') YIELD row ");
        //apocSql.append("CREATE (n:TestCommunity {community_id: row.community_id, community_name: row.community_name})");
        //StatementResult statementResult = excuteCypherSql(apocSql.toString());
        StringBuilder apocSql = new StringBuilder();
        apocSql.append(" CALL apoc.load.jdbc('jdbc:mysql://172.16.4.83:3306/ibmp\\?user=ibmp_test&password=XZdfjXIEsrumGrfFTmfltbtAuQCECUdl&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC', 'select * from basic_community') YIELD row ");
        apocSql.append(" CREATE (n:TestCommunity {community_id: row.community_id, community_name: row.community_name})");
        communityMapper.loadCommunity(apocSql.toString());
        return communityMapper.findCommunity();
    }

}
