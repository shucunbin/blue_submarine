package io.blue.submarine.han.core.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户订阅信息索引文档信息.
 *
 * @author shucunbin
 * @date 2022-01-20 14:35
 */
@Getter
@Setter
public class UserSubInfo {
    private Long userId;
    private String keyword;
    private List<String> category;
    private String merchant;
    private String lang;
    private Long createTime;
    private Long updateTime;
}
