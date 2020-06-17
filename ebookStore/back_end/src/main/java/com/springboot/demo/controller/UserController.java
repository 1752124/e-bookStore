package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("v1/user-management")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public User searchOrderList(@RequestParam String phone) {
        User user = userService.selectByPhone(phone);
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(@RequestParam String name, @RequestParam String phone, @RequestParam String password) {
        int user = userService.insert(name, phone, password);
        return user;
    }
}