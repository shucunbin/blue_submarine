package io.blue.submarine.han;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类.
 *
 * @author shucunbin
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "io.blue.submarine.han.rpc")
public class Han091Application {
    public static void main(String[] args) {
        SpringApplication.run(Han091Application.class, args);
    }
}
