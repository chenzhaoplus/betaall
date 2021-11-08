package com.tyg.neo4j.test.controller;

import com.tyg.neo4j.test.service.ZzSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * 学校管理
 *
 * @author chenz
 */
@RestController
@RequestMapping("/school")
public class ZzSchoolController {

    @Autowired
    private ZzSchoolService schoolService;

    @RequestMapping(value = "/testNeo4j", method = RequestMethod.POST)
    public void testNeo4j() throws Exception {
        List list = schoolService.testNeo4j();
        System.out.println(list);
    }

}
