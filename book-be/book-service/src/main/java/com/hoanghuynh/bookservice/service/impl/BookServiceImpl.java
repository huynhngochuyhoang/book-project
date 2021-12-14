package com.hoanghuynh.bookservice.service.impl;

import com.hoanghuynh.bookservice.model.Book;
import com.hoanghuynh.bookservice.repository.BookRepository;
import com.hoanghuynh.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

}
