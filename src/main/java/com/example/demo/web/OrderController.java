package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lgx
 * @date 2021/1/4  20:43
 */
@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderDao orderDao;

    @Value("${config.content}")
    private String name;

    @GetMapping(value = "/getName")
    public String getName() {
        return "order-service-9001:name======="+name;
    }

    @GetMapping(value = "/list")
    public List<Order> getAccounts() {
        return orderDao.findAll();
    }

    @GetMapping(value = "/setOrder")
    public String setOrder() {
        Order order = new Order();
        order.setName( "订单--order1" );
        orderDao.save( order );
        return "success";
    }
}
