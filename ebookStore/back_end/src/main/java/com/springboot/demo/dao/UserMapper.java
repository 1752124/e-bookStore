package com.springboot.demo.dao;

import com.springboot.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User selectByPhone(@Param("phone") String phone);

    int insert(@Param("name") String name, @Param("phone") String phone, @Param("password") String password);
}