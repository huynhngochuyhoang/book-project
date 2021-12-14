package com.hoanghuynh.bookservice.controller;

import com.hoanghuynh.bookservice.model.Book;
import com.hoanghuynh.bookservice.repository.BookRepository;
import com.hoanghuynh.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBook() {
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookRepository.findById(id).orElseThrow());
    }
}
