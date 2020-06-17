package com.springboot.demo.service.impl;

import com.springboot.demo.dao.CartMapper;
import com.springboot.demo.entity.CartEntity;
import com.springboot.demo.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;

    @Override
    public List<CartEntity> selectByUserId(Integer userId) {
        return cartMapper.selectByUserId(userId);
    }

    @Override
    public int insert(Integer userId, Integer bookId, Integer number) {
        //先校验是否存在userId、bookId
        int count = cartMapper.selectCount(userId, bookId);
        int num;
        if (count > 0) {
            num = cartMapper.add(userId, bookId, number);
        } else {
            num = cartMapper.insert(userId, bookId, number);
        }
        return num;
    }

    @Override
    public int delete(Integer userId, Integer bookId) {
        return cartMapper.delete(userId, bookId);
    }

    @Override
    public int update(Integer userId, Integer bookId, Integer number) {
        return cartMapper.update(userId, bookId, number);
    }
}
