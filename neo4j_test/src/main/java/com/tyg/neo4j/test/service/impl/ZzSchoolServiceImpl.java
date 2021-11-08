package com.tyg.neo4j.test.service.impl;

import com.tyg.neo4j.test.mapper.ZzSchoolMapper;
import com.tyg.neo4j.test.service.ZzSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: cz
 * @Date: 2021/11/8
 * @Description:
 */
@Service
public class ZzSchoolServiceImpl implements ZzSchoolService {

    @Autowired
    private ZzSchoolMapper schoolMapper;

    @Override
    public List testNeo4j() {
        return schoolMapper.testNeo4j();
    }

}
