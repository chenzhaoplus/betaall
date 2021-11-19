package com.tyg.neo4j.test.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.tyg.neo4j.test.service.BasicCommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @Author: cz
 * @Date: 2021/11/8
 * @Description:
 */
@RestController
@RequestMapping("/community")
@Slf4j
public class BasicCommunityController {

    @Autowired
    private BasicCommunityService communityService;

    @RequestMapping(value = "/loadCommunity", method = RequestMethod.POST)
    public List loadCommunity() throws Exception {
        return communityService.loadCommunity();
    }

    @GetMapping(value = "/testDruid")
    public List testDruid() throws Exception {
        log.info("[test success]");
        return communityService.testDruid();
    }

}
