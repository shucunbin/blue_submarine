package io.blue.submarine.han.core.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户信息.
 *
 * @author shucunbin
 */
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private Long userId;
    private String name;
}
