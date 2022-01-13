package io.blue.submarine.han.core.shardingsphere.encryptor;

import org.apache.shardingsphere.encrypt.strategy.spi.QueryAssistedEncryptor;

import java.util.Properties;

/**
 * 自定义加密算法：相同的数据，密文不一样，防止撞库成功.
 *
 * @author shucunbin
 */
public final class CustomQueryAssistedEncryptor implements QueryAssistedEncryptor {
    private Properties properties;

    @Override
    public String queryAssistedEncrypt(String plaintext) {
        return null;
    }

    @Override
    public void init() {
    }

    @Override
    public String encrypt(Object plaintext) {
        return null;
    }

    @Override
    public Object decrypt(String ciphertext) {
        return null;
    }

    @Override
    public String getType() {
        return "custom_assisted_encryptor";
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
