package io.blue.submarine.han.core.shardingsphere.config;

import java.lang.annotation.*;

/**
 * 强制路由到主库.
 *
 * @author shucunbin
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HintMaster {
}
