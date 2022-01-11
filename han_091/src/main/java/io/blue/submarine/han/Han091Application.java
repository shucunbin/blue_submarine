package io.blue.submarine.han;

import io.blue.submarine.han.dao.mapper.user.UserMapper;
import io.blue.submarine.han.service.OrderService;
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
    private OrderService orderService;

    @Resource
    private UserMapper userMapper;


    public static void main(String[] args) {
        SpringApplication.run(Han091Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.complexProcess();
//        orderService.findByUserId(1L);
//        orderService.findByUserId(2L);
//
//        Order order1 = orderService.findByOrderId(1);
//        System.out.println(order1);
//
//        Order orderFromMaster = orderService.findByOrderIdFromMaster(1);
//        System.out.println("order query from master ===> " + orderFromMaster);


//
//        userMapper.findByUserId(1);
//        userMapper.findByUserId(2);
    }
}
