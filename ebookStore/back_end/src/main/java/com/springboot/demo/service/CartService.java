package com.springboot.demo.service;

import com.springboot.demo.entity.CartEntity;

import java.util.List;

public interface CartService {
    List<CartEntity> selectByUserId(Integer userId);

    int insert(Integer userId, Integer bookId, Integer number);

    int delete(Integer userId, Integer bookId);

    int update(Integer userId, Integer bookId, Integer number);
}