package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.resident.ResidentSubsidyInfo;

import java.util.List;

/**
 * 居民补助信息索引接口.
 *
 * @author shucunbin
 * @date 2022-02-06 14:34
 */
public interface ResidentSubsidyInfoIndexService {
    /**
     * 创建居民补助信息索引.
     */
    void createResidentSubsidyInfoIndexIfNotExist();

    /**
     *  索引一个居民补助信息对象到索引中.
     *
     * @param residentSubsidyInfo 居民补助信息对象
     */
    void indexResidentSubsidyInfo(ResidentSubsidyInfo residentSubsidyInfo);

    /**
     * 批量索引居民补助信息.
     *
     * @param residentSubsidyInfoList 居民补助信息列表
     */
    void batchIndexResidentSubsidyInfo(List<ResidentSubsidyInfo> residentSubsidyInfoList);

    /**
     * 查询居民补助信息.
     *
     * @param startDate 起始日期
     * @param endDate 截止日期
     * @return 居民补助信息列表
     */
    List<ResidentSubsidyInfo> searchResidentSubsidyInfo(String startDate, String endDate);
}
