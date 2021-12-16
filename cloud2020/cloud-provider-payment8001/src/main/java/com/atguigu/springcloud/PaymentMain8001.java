package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication          //主启动
@EnableEurekaClient
@EnableDiscoveryClient//开启服务发现
public class PaymentMain8001 {
    public static void main(String[] args) {
    //    该方法返回一个ConfigurableApplicationContext对象
    //    参数1：应用入口的类    参数类：命令行参数
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
