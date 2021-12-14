package com.hoanghuynh.orderservice.service;

import com.hoanghuynh.orderservice.model.BookOrder;

import java.util.List;

public interface BookOrderService {

    List<BookOrder> getAllByStatus(int status);
}
