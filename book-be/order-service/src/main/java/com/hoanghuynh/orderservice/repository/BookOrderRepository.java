package com.hoanghuynh.orderservice.repository;

import com.hoanghuynh.orderservice.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {

    List<BookOrder> findBookOrdersByOrderStatus(int status);

}
