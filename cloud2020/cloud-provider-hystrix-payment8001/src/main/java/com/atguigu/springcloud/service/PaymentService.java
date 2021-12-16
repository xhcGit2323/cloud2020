package com.atguigu.springcloud.service;


public interface PaymentService {
    String paymentInfo_Ok(Integer id);
    String paymentInfo_TimeOut(Integer id);
    String paymentCircuitBreaker(Integer id);
}
