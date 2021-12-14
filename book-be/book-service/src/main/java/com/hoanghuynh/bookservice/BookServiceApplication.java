package com.hoanghuynh.bookservice;

import com.hoanghuynh.bookservice.model.Book;
import com.hoanghuynh.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) {
        List<Book> books = new ArrayList<>();
        books.add(Book.builder()
                .name("Java Core for Beginner")
                .image("https://m.media-amazon.com/images/I/51K24abqIvL.jpg")
                .year(2010)
                .price(400000L)
                .build());
        books.add(Book.builder()
                .name("Java Advance")
                .image("https://images-na.ssl-images-amazon.com/images/I/913t+wVT6fL.jpg")
                .year(2014)
                .price(500000L)
                .build());
        books.add(Book.builder()
                .name("Data Structure and Algorithms")
                .image("https://m.media-amazon.com/images/I/51a0slNQpoL.jpg")
                .year(2008)
                .price(350000L)
                .build());
        books.add(Book.builder()
                .name("Data Structure and Algorithms Massive Dataset")
                .image("https://images.manning.com/360/480/resize/book/0/0f80bf8-681b-453e-b582-bae5909e6036/Medjedovic-Algorithms-HI-MEAP.png")
                .year(2016)
                .price(300000L)
                .build());
        books.add(Book.builder()
                .name("SQL for Only Beginner")
                .image("https://www.datapine.com/blog/wp-content/uploads/2016/11/sql-quick-start-guide-the-simplified-beginners-guide-to-sql-by-clyde-bank-technology.jpg")
                .year(2020)
                .price(320000L)
                .build());
        books.add(Book.builder()
                .name("The Complete SQL Cookbook")
                .image("https://www.guru99.com/images/2/060520_1032_14BESTSQLBo4.jpg")
                .year(2010)
                .price(250000L)
                .build());
        books.add(Book.builder()
                .name("Kubernetes Cookbook")
                .image("https://m.media-amazon.com/images/I/41FhU5TNKrL.jpg")
                .year(2021)
                .price(330000L)
                .build());
        books.add(Book.builder()
                .name("Kubernetes In Action")
                .image("https://product.hstatic.net/200000211451/product/43dc8e4f-0303-429f-bee9-6ccc90fe2495_4cc5afe008474d13a7b9b2510bb797cd_master.jpg")
                .year(2021)
                .price(200000L)
                .build());
        books.add(Book.builder()
                .name("Complete Docker Cookbook")
                .image("https://m.media-amazon.com/images/I/41v6izTzuWL.jpg")
                .year(2020)
                .price(250000L)
                .build());
        books.add(Book.builder()
                .name("Docker step by step")
                .image("https://m.media-amazon.com/images/I/41ETIbPI37L.jpg")
                .year(2020)
                .price(240000L)
                .build());
        books.add(Book.builder()
                .name("Building Microservice")
                .image("https://images-na.ssl-images-amazon.com/images/I/519Q46LvdCL._SX379_BO1,204,203,200_.jpg")
                .year(2021)
                .price(310000L)
                .build());
        books.add(Book.builder()
                .name("Microservice Pattern")
                .image("https://microservices.io/i/Microservices-Patterns-Cover.png")
                .year(2020)
                .price(260000L)
                .build());
        if (bookRepository.findAll().isEmpty())
            bookRepository.saveAll(books);
    }
}
