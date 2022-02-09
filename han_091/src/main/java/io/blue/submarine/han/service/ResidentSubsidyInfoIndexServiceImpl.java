package io.blue.submarine.han.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import io.blue.submarine.han.core.model.resident.ResidentSubsidyInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 居民补助信息索引实现类.
 *
 * @author shucunbin
 * @date 2022-02-06 14:47
 */
@Service
@Slf4j
public class ResidentSubsidyInfoIndexServiceImpl implements ResidentSubsidyInfoIndexService {
    private static final String INDEX_NAME = "resident_subsidy_info_v3";
    private static final String INDEX_TYPE = "data";

    private final TransportClient transportClient;

    private final ObjectMapper objectMapper;

    public ResidentSubsidyInfoIndexServiceImpl(TransportClient transportClient, ObjectMapper objectMapper) {
        this.transportClient = transportClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public void createResidentSubsidyInfoIndexIfNotExist() {
        if (transportClient.admin().indices().prepareExists(INDEX_NAME).get().isExists()) {
            return;
        }

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("META-INF/elastic/" +
                "resident_subsidy_info_mapping.json");
        if (inputStream == null) {
            return;
        }

        String mappingSource = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));
        Settings settings = Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 3)
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
    public void indexResidentSubsidyInfo(ResidentSubsidyInfo residentSubsidyInfo) {
        String sourceJsoStr = objectMapper.writeValueAsString(residentSubsidyInfo);
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
    public void batchIndexResidentSubsidyInfo(List<ResidentSubsidyInfo> residentSubsidyInfoList) {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        for (ResidentSubsidyInfo residentSubsidyInfo : residentSubsidyInfoList) {
            IndexRequestBuilder indexRequest = transportClient.prepareIndex(INDEX_NAME, INDEX_TYPE)
                    .setSource(objectMapper.writeValueAsString(residentSubsidyInfo), XContentType.JSON);
            bulkRequestBuilder.add(indexRequest);
        }
        BulkResponse response = bulkRequestBuilder.get();
        log.info("the result of index document is {}", response.status());
    }

    @Override
    @SneakyThrows
    public List<ResidentSubsidyInfo> searchResidentSubsidyInfo(String startDate, String endDate) {
        SearchResponse response = transportClient.prepareSearch(INDEX_NAME).setTypes(INDEX_TYPE)
                .setQuery(QueryBuilders.rangeQuery("subsidies_date")
                        .format("yyyyMM")
                        .gte(startDate)
                        .lte(endDate))
                .setSize(10000)
                .get();
        List<ResidentSubsidyInfo> residentSubsidyInfoList = Lists.newArrayList();
        SearchHit[] searchHits = response.getHits().getHits();
        for (SearchHit searchHit : searchHits) {
            ResidentSubsidyInfo residentSubsidyInfo = objectMapper.readValue(searchHit.getSourceAsString(),
                    ResidentSubsidyInfo.class);
            residentSubsidyInfoList.add(residentSubsidyInfo);
        }
        return residentSubsidyInfoList;
    }
}
