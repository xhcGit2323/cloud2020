package com.atguigu.springcloud;

import com.atguigu.springcloud.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping(value = "/consumer/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_Ok(id);
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping(value = "/consumer/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeOut_Handler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 80 paymentInfo_TimeOut_Handler,id："+id+"\t服务超时";
    }

}
