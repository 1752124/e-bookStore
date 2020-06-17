package com.springboot.demo.service;

import com.springboot.demo.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> select();

    Book selectByPrimaryKey(Integer id);

    List<Book> selectByLikeTitle(String keyword);
}