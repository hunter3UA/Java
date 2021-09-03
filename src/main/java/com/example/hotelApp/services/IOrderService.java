package com.example.hotelApp.services;

import com.example.hotelApp.dto.OrderDTO;
import com.example.hotelApp.dto.UpdateOrderDTO;
import com.example.hotelApp.models.Order;

import java.util.List;

public interface IOrderService {

    OrderDTO createOrder(Integer user_id);
    List<OrderDTO> allByUser(Integer user_id);

    OrderDTO updateOrder(UpdateOrderDTO updateOrderDTO);


}
