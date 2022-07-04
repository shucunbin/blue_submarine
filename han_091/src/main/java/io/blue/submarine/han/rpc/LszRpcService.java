package io.blue.submarine.han.rpc;

import feign.hystrix.FallbackFactory;
import io.blue.submarine.han.core.model.resident.ResidentSubsidyInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 居民补贴查询接口.
 *
 * @author shucunbin
 * @date 2022-02-06 15:12
 */
@FeignClient(contextId = "lszRpcService",name = "lsz-rpc-service", url = "http://lszrs.com.cn:8003/lsrs/front/wxquery/",
        fallbackFactory = LszRpcService.LszRpcServiceFallbackFactory.class)
public interface LszRpcService {

    @RequestMapping(value = "/base", method = RequestMethod.GET)
    String getResidentSubsidyInfo(@RequestParam("reqParam") String reqParam);

    @Component
    @Slf4j
    class LszRpcServiceFallbackFactory implements FallbackFactory<LszRpcService> {

        @Override
        public LszRpcService create(Throwable cause) {
            return new LszRpcService() {
                @Override
                public String getResidentSubsidyInfo(String reqParam) {
                    log.error("远程请求http://wt.lsz.gov.cn:8003/lsrs/front/wxquery/base 获取居民补助信息异常",
                            "LszRpcService-getResidentSubsidyInfo", cause);
                    return null;
                }
            };
        }
    }
}
