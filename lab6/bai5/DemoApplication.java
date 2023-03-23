package com.example.bai5;

import com.example.bai5.Config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println("Application Name: " + appConfig.getAppName());
        System.out.println("Application Version: " + appConfig.getAppVersion());
    }

}
