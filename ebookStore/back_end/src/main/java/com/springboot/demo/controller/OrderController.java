package com.springboot.demo.controller;

import com.springboot.demo.entity.Cart;
import com.springboot.demo.entity.Order;
import com.springboot.demo.entity.OrderEntity;
import com.springboot.demo.service.impl.CartServiceImpl;
import com.springboot.demo.service.impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("v1/order-management")
public class OrderController {
    @Resource
    private OrderServiceImpl orderService;

    @RequestMapping(value = "orderlists", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderEntity> searchOrderList(@RequestParam Integer userid) {
        List<OrderEntity> orderList = orderService.selectByUserId(userid);
        return orderList;
    }

    @RequestMapping(value = "orders", method = RequestMethod.POST)
    @ResponseBody
    public int addOrder(@RequestParam Integer userid, @RequestParam Integer bookid, @RequestParam Integer number) {
        int order = orderService.insert(userid, bookid, number);
        return order;
    }
}
