package com.taiyangguo.springtemplate.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 生产kafka数据
     *
     * @param topic
     * @param key
     * @param data
     * @return
     */
    public boolean sendKafka(String topic, String key, String data) {
        boolean result = false;
        try {
            kafkaTemplate.send(topic, key, data);
            result = true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    /**
     * 数据推送
     *
     * @param obj
     */
    public void sendData2Kafka(String topic, Object obj) {
        try {
            sendKafka(topic, UUID.randomUUID().toString(), JSON.toJSONString(obj));
        } catch (Exception e) {
            log.error("数据推送kafka失败，topic：{}，数据：{}", topic, JSON.toJSONString(obj));
        }

    }
}
