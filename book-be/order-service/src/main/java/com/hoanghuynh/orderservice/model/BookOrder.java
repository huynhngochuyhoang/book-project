package com.hoanghuynh.orderservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book_order")
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_order_id")
    private String bookOrderId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_status")
    private int orderStatus;
}
