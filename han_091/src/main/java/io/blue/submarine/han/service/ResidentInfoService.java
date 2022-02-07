package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.resident.ResidentInfo;

import java.util.List;

/**
 * 居民信息服务接口.
 *
 * @author shucunbin
 * @date 2022-02-06 19:08
 */
public interface ResidentInfoService {
    /**
     * 从 excel 文档中读取居民信息.
     *
     * @return 居民信息列表
     */
    List<ResidentInfo> readFromExcel();
}
