package com.hoanghuynh.bookservice.model;

import lombok.Data;

@Data
public class BookOrderDto {
    private String userId;
    private Long bookId;
}
