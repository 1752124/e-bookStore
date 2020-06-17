package com.springboot.demo.controller;

import com.springboot.demo.entity.Book;
import com.springboot.demo.service.BookService;
import com.springboot.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("v1/book-management")
public class BookController {
    @Resource
    private BookServiceImpl bookService;

    @RequestMapping(value = "booklists", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> showBookList() {
        List<Book> booklist  = bookService.select();
        return booklist;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    @ResponseBody
    public Book showBook(@RequestParam Integer id) {
        Book book  = bookService.selectByPrimaryKey(id);
        return book;
    }

    @RequestMapping(value = "titles", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> searchBookList(@RequestParam String keyword) {
        List<Book> booklist = bookService.selectByLikeTitle(keyword);
        return booklist;
    }


}
