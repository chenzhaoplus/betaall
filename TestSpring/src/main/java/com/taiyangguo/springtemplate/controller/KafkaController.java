package com.taiyangguo.springtemplate.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import com.alibaba.fastjson.JSONObject;
import com.taiyangguo.springtemplate.service.impl.KafkaService;
import com.taiyangguo.springtemplate.utils.CsvUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

/**
 * @Author: cz
 * @Date: 2021/4/23
 * @Description:
 */
@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping(value = "/test")
    public String sendMessage(@RequestBody JSONObject jsonObject) throws Exception {
        log.info("[test success]");
        kafkaService.sendData2Kafka(jsonObject.getString("topic"), jsonObject.getJSONObject("data"));
        return "success";
    }

    public static void main(String[] args) {
        Set<String> strings = Charset.availableCharsets().keySet();
        System.out.println(strings);
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);
    }

}
