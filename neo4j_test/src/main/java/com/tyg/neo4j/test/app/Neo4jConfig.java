//package com.tyg.neo4j.test.app;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.neo4j.driver.v1.AuthTokens;
//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.GraphDatabase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
//@Configuration
////@EnableConfigurationProperties(Neo4jProperties.class)
//public class Neo4jConfig {
//
//    //private Neo4jProperties neo4jProperties;
//    //
//    //public Neo4jConfig(Neo4jProperties neo4jProperties) {
//    //    this.neo4jProperties = neo4jProperties;
//    //}
//    //
//    ///**
//    // * 图数据库驱动模式
//    // *
//    // * @return
//    // */
//    //@Bean
//    //public Driver neo4jDriver() {
//    //    return GraphDatabase.driver(neo4jProperties.getUri(), AuthTokens.basic(neo4jProperties.getUsername(),
//    //            neo4jProperties.getPassword()));
//    //}
//
//}
