package com.example.hotelApp.repository;

import com.example.hotelApp.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Integer> {

    @Query(value = "SELECT *FROM public.orders WHERE user_id=?",nativeQuery = true)
    ArrayList<Order> allByUserID(Integer user_id);

}
