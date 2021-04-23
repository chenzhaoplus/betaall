package com.sinosoft.elasticsearch.config.es;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.sinosoft.elasticsearch.boot.mapper")
public class ElasticsearchConfig {

    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.clustername}")
    private String esClusterName;

    @Value("${elasticsearch.search.pool.size}")
    private Integer threadPoolSearchSize;

    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.builder()
                .put("cluster.name", esClusterName)
                //增加嗅探机制，找到ES集群,非集群置为false
                .put("client.transport.sniff", true)
                //增加线程池个数
                .put("thread_pool.search.size", threadPoolSearchSize)
                .put("client.transport.ping_timeout", "60s")
                .build();
        PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(esSettings);
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(esHost), esPort);
        TransportClient transportClient = preBuiltTransportClient.addTransportAddress(transportAddress);
        return transportClient;
    }

    @Bean(name="elasticsearchTemplate")
    public ElasticsearchOperations elasticsearchTemplate(ElasticsearchConverter converter) throws Exception {
        ElasticsearchTemplate elasticsearchTemplate;
        try {
            Client client = client();
            elasticsearchTemplate = new ElasticsearchTemplate(client, new ElasticsearchEntityMapper(converter.getMappingContext(), null));
//            elasticsearchTemplate = new ElasticsearchTemplate(client);
            return elasticsearchTemplate;
        } catch (Exception e) {
            log.error("初始化ElasticsearchTemplate失败");
            Client client = client();
            return new ElasticsearchTemplate(client);
        }
    }
}
