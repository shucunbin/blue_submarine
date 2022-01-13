package io.blue.submarine.han.core.shardingsphere.algorithm;

import org.apache.shardingsphere.spi.masterslave.MasterSlaveLoadBalanceAlgorithm;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 自定义读写分离算法.
 *
 * @author shucunbin
 */
public class CustomMasterSlaveLoadBalanceAlgorithm implements MasterSlaveLoadBalanceAlgorithm {
    private Properties properties = new Properties();

    @Override
    public String getDataSource(String name, String masterDataSourceName, List<String> slaveDataSourceNames) {
        System.out.println("**************** 自定义读写分离算法 ****************");
        // 自定义算法逻辑
        return slaveDataSourceNames.get(ThreadLocalRandom.current().nextInt(slaveDataSourceNames.size()));
    }

    @Override
    public String getType() {
        return "CUSTOM_RANDOM";
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
