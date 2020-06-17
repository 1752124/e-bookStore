package com.springboot.demo.service.impl;

import com.springboot.demo.dao.OrderMapper;
import com.springboot.demo.entity.Book;
import com.springboot.demo.entity.Order;
import com.springboot.demo.entity.OrderEntity;
import com.springboot.demo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderEntity> selectByUserId(Integer userId) {
        List<OrderEntity> list = orderMapper.selectByUserId(userId);
        return list;
    }

    @Override
    public int insert(Integer userId, Integer bookId, Integer number) {
        return orderMapper.insert(userId, bookId, number);
    }
}
