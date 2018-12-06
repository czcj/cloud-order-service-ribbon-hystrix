package com.meng.orderserviceribbonhystrix.controller;

import com.meng.orderserviceribbonhystrix.OrderServiceRibbonHystrixApplication;
import com.meng.orderserviceribbonhystrix.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("getOrder")
    public String getOrder(){
        return orderService.getProduct("order-server-ribbon-hystrix");
    }
}
