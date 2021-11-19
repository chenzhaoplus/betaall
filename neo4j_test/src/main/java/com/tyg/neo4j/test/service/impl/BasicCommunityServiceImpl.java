package com.tyg.neo4j.test.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.tyg.neo4j.test.mapper.BasicCommunityMapper;
import com.tyg.neo4j.test.service.BasicCommunityService;
//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.Session;
//import org.neo4j.driver.v1.StatementResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * @Author: cz
 * @Date: 2021/11/8
 * @Description:
 */
@Service
@Slf4j
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

    @Override
    @SneakyThrows(Exception.class)
    public List testDruid() {
        DruidPooledConnection connection = generateDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("match (n:BasicCommunity) return n.community_id as communityId, n.community_name as communityName");
        List list = getListFromResultSet(resultSet);
        log.info("list = {}", list);
        return list;
    }

    private List getListFromResultSet(ResultSet resultSet) throws SQLException {
        List resultList = new ArrayList();
        while (resultSet.next()) {
            Map map = new LinkedHashMap();
            int colCount = resultSet.getMetaData().getColumnCount();
            for (int i = 0; i < colCount; i++) {
                map.put(resultSet.getMetaData().getColumnName(i + 1), resultSet.getObject(i + 1));
            }
            resultList.add(map);
        }
        return resultList;
    }

    private DruidDataSource generateDataSource() throws Exception {
        DruidDataSource dataSource = null;
        String splitFlag = "/";

        Properties properties = new Properties();
        properties.setProperty("druid.username", "neo4j");
        properties.setProperty("druid.password", "smcaiot");
        properties.setProperty("druid.driverClassName", "org.neo4j.jdbc.bolt.BoltDriver");
        properties.setProperty("druid.maxActive", "50");
        properties.setProperty("druid.initialSize", "5");
        properties.setProperty("druid.minIdle", "1");
        properties.setProperty("druid.maxWait", "30000");
        properties.setProperty("druid.filters", "stat");
        properties.setProperty("druid.timeBetweenEvictionRunsMillis", "10000");
        properties.setProperty("druid.url", "jdbc:neo4j:bolt://172.16.4.82:7687");
        log.debug("druid.url = {}", properties.get("druid.url"));

        dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        return dataSource;
    }

}
