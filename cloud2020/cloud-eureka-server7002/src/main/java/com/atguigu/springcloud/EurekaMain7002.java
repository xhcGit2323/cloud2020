package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //
public class EurekaMain7002 {

    public static void main(String[] args) {
    //    该方法返回一个ConfigurableApplicationContext对象
    //    参数1：应用入口的类    参数类：命令行参数
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
