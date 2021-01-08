package com.example.demo.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by forezp on 2019/5/11.
 */
@FeignClient("toyStock")
public interface ToyStockClient {

    @GetMapping("/toyStock/setToyStock")
    String setToyStock();
    @GetMapping("/toyStock/setToyStockException")
    String setToyStockException();
}


