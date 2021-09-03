package com.example.hotelApp.controllers;

import com.example.hotelApp.dto.OrderDTO;
import com.example.hotelApp.dto.UpdateOrderDTO;
import com.example.hotelApp.models.Order;
import com.example.hotelApp.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @PostMapping("/order/{user_id}")
    public OrderDTO createOrder(@PathVariable(name = "user_id")Integer user_id){
        return orderService.createOrder(user_id);
    }

    @GetMapping("/order/{user_id}")
    public List<OrderDTO> ordersByUser(@PathVariable(name = "user_id")Integer user_id){
        return orderService.allByUser(user_id);
    }

    @PutMapping("/order")
    public OrderDTO updateOrder(@RequestBody UpdateOrderDTO updateOrderDTO){
        return orderService.updateOrder(updateOrderDTO);
    }

}
