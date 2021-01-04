package com.example.demo.web;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lgx
 * @date 2021/1/4  20:38
 */
@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
