package com.atguigu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //
@EnableConfigServer
public class ConfigCenterMain3344 {

    private static Logger log = LoggerFactory.getLogger(ConfigCenterMain3344.class);
    public static void main(String[] args) {
    //    该方法返回一个ConfigurableApplicationContext对象
    //    参数1：应用入口的类    参数类：命令行参数
        SpringApplication.run(ConfigCenterMain3344.class, args);
        log.info("***************************************************************************");
    }
}
