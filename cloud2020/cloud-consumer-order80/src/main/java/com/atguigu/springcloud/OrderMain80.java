package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//要访问CLOUD-PAYMENT-SERVICE服务，配置使用自定义MySelfRule负载均衡策略
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
    //    该方法返回一个ConfigurableApplicationContext对象
    //    参数1：应用入口的类    参数类：命令行参数
        SpringApplication.run(OrderMain80.class, args);
    }
}
