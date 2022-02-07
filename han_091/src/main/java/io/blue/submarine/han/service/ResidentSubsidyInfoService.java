package io.blue.submarine.han.service;

/**
 * 居民补助信息服务接口.
 *
 * @author shucunbin
 * @date 2022-02-07 10:22
 */
public interface ResidentSubsidyInfoService {
    /**
     * 初始化居民补助信息.
     */
    void initData();

    /**
     * 导出居民补助信息 excel 文件
     */
    void exportExcel();
}
