package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "--------------PaymentFallbackService fallback paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------------PaymentFallbackService fallback paymentInfo_TimeOut";
    }
}
