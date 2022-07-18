package com.example.mybookstore2.service.impl;


import com.example.mybookstore2.entity.Book;
import com.example.mybookstore2.mapper.BookMapper;
import com.example.mybookstore2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> queryList() {
        return bookMapper.queryList();
    }

    @Override
    public List<Book> queryByKind(String kind) {
        return bookMapper.queryByKind(kind);
    }

    @Override
    public Book queryById(Integer id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<Book> queryAllByLimit(int offset, int limit) {
        return bookMapper.queryAllByLimit(offset,limit);
    }

    @Override
    public Book insert(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        bookMapper.update(book);
        return book;
    }

    @Override
    public boolean deleteById(Integer id) {
        return bookMapper.deleteById(id)>0 ;
    }
}
