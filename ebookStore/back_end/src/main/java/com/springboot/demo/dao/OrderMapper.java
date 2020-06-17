package com.springboot.demo.dao;

import com.springboot.demo.entity.Order;
import com.springboot.demo.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int insert(@Param("userId") Integer userId, @Param("bookId") Integer bookId, @Param("number") Integer number);

    List<OrderEntity> selectByUserId(@Param("userId") Integer userId);
}