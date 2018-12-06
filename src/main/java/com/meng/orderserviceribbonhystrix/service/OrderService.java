package com.meng.orderserviceribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "productError")
    public String getProduct(String s) {
        String forObject = restTemplate.getForObject("http://product-service/product/getProduct?id=" + s, String.class);
        return forObject;
    }

    public String productError(String s){
        return "ribbon-hystrix-success";
    }
}
