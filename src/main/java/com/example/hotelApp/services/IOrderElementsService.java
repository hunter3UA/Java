package com.example.hotelApp.services;

import com.example.hotelApp.dto.OrderElementDTO;

import java.util.List;

public interface IOrderElementsService {
    List<OrderElementDTO> getByOrderID(Integer orderID);
}
