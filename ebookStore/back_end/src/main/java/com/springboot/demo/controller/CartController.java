package com.springboot.demo.controller;

import com.springboot.demo.entity.CartEntity;
import com.springboot.demo.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("v1/cart-management")
public class CartController {
    @Resource
    private CartServiceImpl cartService;

    @RequestMapping(value = "cartlists", method = RequestMethod.GET)
    @ResponseBody
    public List<CartEntity> searchCartList(@RequestParam Integer userid) {
        List<CartEntity> cartList = cartService.selectByUserId(userid);
        return cartList;
    }

    @RequestMapping(value = "/carts", method = RequestMethod.POST)
    @ResponseBody
    public int addCart(@RequestParam Integer userid, @RequestParam Integer bookid, @RequestParam Integer number) {
        int cart = cartService.insert(userid, bookid, number);
        return cart;
    }

    @RequestMapping(value = "/carts", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteCart(@RequestParam Integer userid, @RequestParam Integer bookid) {
        int cart = cartService.delete(userid, bookid);
        return cart;
    }

    @RequestMapping(value = "/carts", method = RequestMethod.PUT)
    @ResponseBody
    public int updateCart(@RequestParam Integer userid, @RequestParam Integer bookid, @RequestParam Integer number) {
        int cart = cartService.update(userid, bookid, number);
        if (number==0) {
            deleteCart(userid, bookid);
        }
        return cart;
    }

}
