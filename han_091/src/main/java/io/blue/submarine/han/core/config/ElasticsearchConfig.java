package io.blue.submarine.han.core.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * elasticsearch 配置类.
 *
 * 注意 springboot、springboot-data-elasticsearch、elasticsearch 之间的版本对应关系.
 * https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#preface.requirements
 *
 * @author shucunbin
 * @date 2022-01-20 13:46
 */
@Configuration
public class ElasticsearchConfig {
    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "es-docker-cluster")
//                        .put("client.transport.sniff", "true")
                .put("client.transport.nodes_sampler_interval", "5s")
                .put("client.transport.ping_timeout", "5s")
                .put("client.transport.ignore_cluster_name", "false")
                .build();
        return new PreBuiltTransportClient(settings).addTransportAddress(
                new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }
}
