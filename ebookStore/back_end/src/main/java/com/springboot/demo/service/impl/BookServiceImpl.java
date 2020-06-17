package com.springboot.demo.service.impl;

import com.springboot.demo.dao.BookMapper;
import com.springboot.demo.entity.Book;
import com.springboot.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> select(){ return bookMapper.select(); }

    @Override
    public Book selectByPrimaryKey(Integer id){ return bookMapper.selectByPrimaryKey(id); }

    @Override
    public List<Book> selectByLikeTitle(String keyword){ return bookMapper.selectByLikeTitle(keyword); }

}
