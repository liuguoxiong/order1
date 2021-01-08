package com.example.demo.web.service.impl;

import com.example.demo.web.Order;
import com.example.demo.web.OrderDao;
import com.example.demo.web.ToyStockClient;
import com.example.demo.web.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lgx
 * @date 2021/1/6  18:45
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;
    @Resource
    ToyStockClient toyStockClient;

    @Override
    @GlobalTransactional(name = "AT-First")
    public String setOrder(int type) {
        Order order = new Order();
        order.setName( "订单--order1" );
        orderDao.save( order );
        if(type==1){
            toyStockClient.setToyStock();
        }else{
            toyStockClient.setToyStockException();
        }
        return "success";
    }
}
