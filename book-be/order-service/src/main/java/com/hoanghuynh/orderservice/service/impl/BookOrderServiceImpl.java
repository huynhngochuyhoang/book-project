package com.hoanghuynh.orderservice.service.impl;

import com.hoanghuynh.orderservice.model.BookOrder;
import com.hoanghuynh.orderservice.repository.BookOrderRepository;
import com.hoanghuynh.orderservice.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOrderServiceImpl implements BookOrderService {

    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Override
    public List<BookOrder> getAllByStatus(int status) {
        return bookOrderRepository.findBookOrdersByOrderStatus(status);
    }
}
