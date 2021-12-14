package com.hoanghuynh.bookservice.repository;

import com.hoanghuynh.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByYear(int year);
    List<Book> findBooksByPrice(Long price);
}
