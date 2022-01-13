package io.blue.submarine.han.core.shardingsphere.config;

import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.masterslave.route.engine.impl.MasterVisitedManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 读写分离路由增强：
 * 1. 手动需要路由主库时，在方法上添加注解
 * 2. service 层和 dao 层 add、create、save、insert、update、del 开头的方法体内所有 sql 自动路由到主库
 * 3. 在方法头增加 @Transactional 注解的，该方法体内所有sql自动路由到主库
 * 参考：https://llg-software.github.io/2019/03/14/sharding/master-slave-route-append/
 * @author shucunbin
 * @see HintMaster
 */
@Component
@Aspect
public class HintMasterAspect {
    @Around("@annotation(hintMaster)")
    public Object setMasterOnly(ProceedingJoinPoint joinPoint, HintMaster hintMaster) throws Throwable {
        if (HintManager.isMasterRouteOnly() || MasterVisitedManager.isMasterVisited()) {
            return joinPoint.proceed();
        }

        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.setMasterRouteOnly();
            return joinPoint.proceed();
        }
    }
}
