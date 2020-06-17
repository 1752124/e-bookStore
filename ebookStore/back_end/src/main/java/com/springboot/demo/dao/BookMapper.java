package com.springboot.demo.dao;

import com.springboot.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> select();

    Book selectByPrimaryKey(@Param("id") Integer id);

    List<Book> selectByLikeTitle(@Param("keyword") String  keyword);
}