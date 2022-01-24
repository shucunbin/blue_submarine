package io.blue.submarine.han.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import io.blue.submarine.han.core.model.user.UserSubInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户订阅信息索引服务实现类.
 *
 * @author shucunbin
 * @date 2022-01-24 11:05
 */
@Service
@Slf4j
public class UserSubInfoIndexServiceImpl implements UserSubInfoIndexService {
    private static final String INDEX_NAME = "user_subscriber_info";
    private static final String INDEX_TYPE = "data";

    private final TransportClient transportClient;

    private final ObjectMapper objectMapper;

    public UserSubInfoIndexServiceImpl(TransportClient transportClient, ObjectMapper objectMapper) {
        this.transportClient = transportClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public void createUserSubInfoIndex() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("META-INF/elastic/user_sub_info_mapping.json");
        if (inputStream == null) {
            return;
        }

        String mappingSource = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));

        Settings settings = Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 1)
                .build();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX_NAME)
                .settings(settings)
                .source(mappingSource, XContentType.JSON);
        CreateIndexResponse createIndexResponse = transportClient.admin()
                .indices()
                .create(createIndexRequest)
                .actionGet();
        log.info("create index is acknowledge:{}", createIndexResponse.isAcknowledged());
    }

    @Override
    @SneakyThrows
    public void indexUserSubInfo(UserSubInfo userSubInfo) {
        String sourceJsoStr = objectMapper.writeValueAsString(userSubInfo);
        if (Strings.isNullOrEmpty(sourceJsoStr)) {
            return;
        }

        IndexResponse response = transportClient.prepareIndex(INDEX_NAME, INDEX_TYPE)
                .setSource(sourceJsoStr, XContentType.JSON)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .get();
        log.info("the result of index document is {}", response.getResult());
    }

    @Override
    @SneakyThrows
    public void bulkIndexUserSubInfo(List<UserSubInfo> userSubInfoList) {
        if (CollectionUtils.isEmpty(userSubInfoList)) {
            return;
        }

        BulkRequest bulkRequest = new BulkRequest();
        for (UserSubInfo userSubInfo : userSubInfoList) {
            IndexRequest indexRequest = new IndexRequest(INDEX_NAME, INDEX_TYPE)
                    .source(objectMapper.writeValueAsString(userSubInfo), XContentType.JSON)
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulkResponse = transportClient.bulk(bulkRequest).get();
        log.info("the result of bulk index document is {}", bulkResponse.status());
    }
}



/*
每个用户订阅了一些关键字，当一篇文章发布的时候，要找出文章里包含关键字的那些用户。

输入：
折扣的标题 + 亮点

条件：
匹配关键字（分词后所有词都可以在【折扣的标题 + 亮点】中都存在）
分类（若存在）一致
商家（若存在）一致

输出：
匹配的订阅信息
 */