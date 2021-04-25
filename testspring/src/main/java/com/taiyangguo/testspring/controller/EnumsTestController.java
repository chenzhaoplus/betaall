package com.taiyangguo.testspring.controller;

import com.taiyangguo.testspring.enums.strategy.AnimalEnum2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cz
 * @Date: 2021/4/23
 * @Description:
 */
@RestController
@RequestMapping("/enums")
@Slf4j
public class EnumsTestController {

    @GetMapping(value = "/test")
    public String sendMessage() throws Exception {
        log.info("[test success]");
        test();
        return "success";
    }

    private void test(){
        String type = AnimalEnum2.CAT.name();
        String catEat = AnimalEnum2.valueOf(type).getService().eat();
        System.out.println(catEat);

        int value = AnimalEnum2.PANDA.getValue();
        String pandaEat = AnimalEnum2.getEnumByValue(value).getService().eat();
        System.out.println(pandaEat);

        String t = AnimalEnum2.MONKEY.name();
        String monEat = AnimalEnum2.valueOf(t).getService().eat();
        System.out.println(monEat);
    }

}
