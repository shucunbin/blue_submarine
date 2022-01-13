package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.user.User;

/**
 * 用户信息服务接口.
 *
 * @author shucunbin
 */
public interface UserService {
    void save(User user);

    User findByUserId(Long userId);

    User findByUserName(String userName);
}
