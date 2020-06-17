package com.springboot.demo.service;

import com.springboot.demo.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> selectByUserId(Integer userId);

    int insert(Integer userId, Integer bookId, Integer number);
}