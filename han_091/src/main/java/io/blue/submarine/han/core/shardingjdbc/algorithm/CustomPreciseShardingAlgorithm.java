package io.blue.submarine.han.core.shardingjdbc.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 自定义精确分片算法（单分片键）.
 *
 * @author shucunbin
 */
public class CustomPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        return null;
    }
}
