package io.blue.submarine.han;

import io.blue.submarine.han.core.model.user.User;
import io.blue.submarine.han.service.OrderService;
import io.blue.submarine.han.service.UserService;
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
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(Han091Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        orderService.complexProcess();

//        User user = new User();
//        user.setUserId(1L);
//        user.setName("zhangsan");
//        userService.save(user);
//        System.out.println(user);

        orderService.findByOrderId(1L);
        orderService.findByOrderIdFromMaster(2L);
        orderService.findByOrderId(3L);

    }
}
