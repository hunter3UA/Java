package com.example.hotelApp.controllers;

import com.example.hotelApp.dto.OrderElementDTO;
import com.example.hotelApp.models.OrderElement;
import com.example.hotelApp.services.IOrderElementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderElementsController {
    @Autowired
    private IOrderElementsService orderElementsService;
    @GetMapping("/orderElement/{order_id}")
    public List<OrderElementDTO> getByOrderID(@PathVariable(name = "order_id")Integer order_id){
        return orderElementsService.getByOrderID(order_id);
    }

}
