package com.springboot.demo.dao;

import com.springboot.demo.entity.CartEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    List<CartEntity> selectByUserId(@Param("userId") Integer userId);

    int delete(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    int insert(@Param("userId") Integer userId, @Param("bookId") Integer bookId, @Param("number") Integer number);

    int update(@Param("userId") Integer userId, @Param("bookId") Integer bookId, @Param("number") Integer number);

    int add(@Param("userId") Integer userId, @Param("bookId") Integer bookId, @Param("number") Integer number);

    int selectCount(@Param("userId") Integer userId, @Param("bookId") Integer bookId);
}