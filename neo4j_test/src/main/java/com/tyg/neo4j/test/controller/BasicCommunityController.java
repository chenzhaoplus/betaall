package com.tyg.neo4j.test.controller;

import com.tyg.neo4j.test.service.BasicCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: cz
 * @Date: 2021/11/8
 * @Description:
 */
@RestController
@RequestMapping("/community")
public class BasicCommunityController {

    @Autowired
    private BasicCommunityService communityService;

    @RequestMapping(value = "/loadCommunity", method = RequestMethod.POST)
    public List loadCommunity() throws Exception {
        return communityService.loadCommunity();
    }

}
