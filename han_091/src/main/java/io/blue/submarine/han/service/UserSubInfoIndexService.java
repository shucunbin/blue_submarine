package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.user.UserSubInfo;

import java.util.List;

/**
 * 用户订阅信息索引服务.
 *
 * @author shucunbin
 * @date 2022-01-24 10:44
 */
public interface UserSubInfoIndexService {
    /**
     * 创建用户订阅信息索引.
     */
    void createUserSubInfoIndex();

    /**
     *  索引一个用户订阅信息对象到索引中.
     *
     * @param userSubInfo 用户订阅信息对象
     */
    void indexUserSubInfo(UserSubInfo userSubInfo);

    /**
     * 批量索引用户订阅信息对象到索引中.
     *
     * @param userSubInfoList 用户订阅信息对象列表
     */
    void bulkIndexUserSubInfo(List<UserSubInfo> userSubInfoList);
}
