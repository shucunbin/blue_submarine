package io.blue.submarine.han;

import io.blue.submarine.han.dao.mapper.order.OrderMapper;
import io.blue.submarine.han.dao.mapper.user.UserMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * 启动类.
 *
 * @author shucunbin
 */
@SpringBootApplication
public class Han091Application implements CommandLineRunner {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private UserMapper userMapper;


    public static void main(String[] args) {
        SpringApplication.run(Han091Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderMapper.findByOrderId(1);
        orderMapper.findByOrderId(2);
        orderMapper.findByOrderId(3);

        userMapper.findByUserId(1);
        userMapper.findByUserId(2);
    }
}
