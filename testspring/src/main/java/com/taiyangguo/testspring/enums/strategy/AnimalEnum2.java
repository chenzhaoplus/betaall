package com.taiyangguo.testspring.enums.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.function.Supplier;

/**
 * @Author: cz
 * @Date: 2020/9/30
 * @Description: 用枚举的方式去掉 if else
 */
@Getter
@AllArgsConstructor
public enum AnimalEnum2 {

    //熊猫
    PANDA(1),
    //猫
    CAT(2),
    //猴子
    MONKEY(3);

    private int value;
    @Setter
    private Supplier<String> service;

    AnimalEnum2(int value){
        this.value = value;
    }

    @Component
    public static class EnumInjector{

        @Autowired
        private PandaServiceImpl pandaService;
        @Autowired
        private CatServiceImpl catService;
        @Autowired
        private MonkeyServiceImpl monkeyService;

        @PostConstruct
        private void postConstruct(){
            PANDA.setService(pandaService::eat);
            CAT.setService(catService::eat);
            MONKEY.setService(monkeyService::eat);
        }

    }

    public static AnimalEnum2 getEnumByValue(int value) {
        for (AnimalEnum2 item : AnimalEnum2.values()) {
            if (item.value == value) {
                return item;
            }
        }
        return null;
    }

}