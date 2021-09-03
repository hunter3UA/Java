package com.example.hotelApp.repository;

import com.example.hotelApp.models.OrderStatus;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusRepository extends CrudRepository<OrderStatus,Integer> {
}
