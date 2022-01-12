package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.user.User;
import io.blue.submarine.han.dao.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息服务接口实现类.
 *
 * @author shucunbin
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findByUserId(Long userId) {
        return userMapper.findByUserId(userId);
    }
}
