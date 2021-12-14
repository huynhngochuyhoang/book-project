package com.hoanghuynh.orderservice.controller;

import com.hoanghuynh.orderservice.model.BookOrder;
import com.hoanghuynh.orderservice.model.BookOrderDto;
import com.hoanghuynh.orderservice.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class BookOrderController {

    @Autowired
    private BookOrderRepository bookOrderRepository;

    @PostMapping("/purchase")
    public ResponseEntity<BookOrder> purchase(@RequestBody BookOrderDto bookOrderDto) {
        BookOrder bookOrder = new BookOrder();
        String orderId = UUID.randomUUID().toString();
        bookOrder.setBookOrderId(orderId);
        bookOrder.setOrderDate(LocalDateTime.now());
        bookOrder.setUserId(bookOrderDto.getUserId());
        bookOrder.setBookId(bookOrderDto.getBookId());
        bookOrder.setOrderStatus(1);
        bookOrderRepository.save(bookOrder);
        return ResponseEntity.ok(bookOrder);
    }
}
