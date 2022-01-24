package io.blue.submarine.han;

import io.blue.submarine.han.service.UserSubInfoIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类.
 *
 * @author shucunbin
 */
@SpringBootApplication
public class Han091Application implements CommandLineRunner {
    @Autowired
    private UserSubInfoIndexService userSubInfoIndexService;

    public static void main(String[] args) {
        SpringApplication.run(Han091Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userSubInfoIndexService.createUserSubInfoIndex();
//
//        UserSubInfo userSubInfo = new UserSubInfo();
//        userSubInfo.setUserId(853715L);
//        userSubInfo.setKeyword("ysl");
//        userSubInfo.setCategory(Lists.newArrayList( "83886081"));
//        userSubInfo.setMerchant("");
//        userSubInfo.setLang("cn");
//        userSubInfo.setCreateTime(System.currentTimeMillis());
//        userSubInfo.setUpdateTime(System.currentTimeMillis());
//        userSubInfoIndex.indexUserSubInfo(userSubInfo);
    }
}
