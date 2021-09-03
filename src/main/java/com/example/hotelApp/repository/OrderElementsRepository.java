package com.example.hotelApp.repository;


import com.example.hotelApp.models.OrderElement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderElementsRepository extends CrudRepository<OrderElement,Integer> {

    @Query(value = "SELECT * FROM public.order_elements WHERE order_id=?",nativeQuery = true)
    List<OrderElement> allByOrderID(Integer order_id);


}
