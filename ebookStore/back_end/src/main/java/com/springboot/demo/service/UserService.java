package com.springboot.demo.service;


import com.springboot.demo.entity.User;

import java.util.List;

public interface UserService {
    User selectByPhone(String phone);

    int insert(String name, String phone, String password);
}