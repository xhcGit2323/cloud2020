package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "paymentInfo_Global_FallbackMethod")
public class PaymentServiceImpl implements PaymentService {

    //服务降级

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk,id：" + id + "\t^_^";
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })

    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id) {
        int timeNum = 10 / 0;
//        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " 8001 paymentInfo_TimeOut,id：" + id + "\t^_^耗时（秒）：" + timeNum;
    }

    public String paymentInfo_TimeOut_Handler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 8001 paymentInfo_TimeOut_Handler,id：" + id + "\t服务超时";
    }

    public String paymentInfo_Global_FallbackMethod() {
        return "Global 异常信息处理";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期/时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")})//失败率达到多少后跳闸
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*********id不能为负数");
        }
        String sn = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功，流水号：" + sn;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "id不能为负数，请稍后再试 id=" + id;
    }


}
