package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication       //主启动
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        //    该方法返回一个ConfigurableApplicationContext对象
        //    参数1：应用入口的类    参数类：命令行参数
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
