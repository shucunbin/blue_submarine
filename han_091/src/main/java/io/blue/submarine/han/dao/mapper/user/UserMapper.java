package io.blue.submarine.han.dao.mapper.user;

import io.blue.submarine.han.core.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 Mapper.
 *
 * @author shucunbin
 */
@Mapper
public interface UserMapper {
    User findByUserId(@Param("userId") Long userId);

    int insert(User user);
}
