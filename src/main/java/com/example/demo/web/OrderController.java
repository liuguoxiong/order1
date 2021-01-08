package com.example.demo.web;

import com.example.demo.web.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lgx
 * @date 2021/1/4  20:43
 */
@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @Value("${config.content}")
    private String name;

    @GetMapping(value = "/getName")
    public String getName() {
        return "order-service-9001:name======="+name;
    }


    @GetMapping(value = "/setOrder")
    public String setOrder(int type) {
        return orderService.setOrder(type);
    }
}
