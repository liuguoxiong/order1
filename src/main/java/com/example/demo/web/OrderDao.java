package com.example.demo.web;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lgx
 * @date 2021/1/4  20:42
 */
public interface OrderDao extends JpaRepository<Order,Integer> {

}
