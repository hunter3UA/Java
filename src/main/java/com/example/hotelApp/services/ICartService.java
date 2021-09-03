package com.example.hotelApp.services;

import com.example.hotelApp.dto.CartDTO;

import java.util.List;

public interface ICartService {
    List<CartDTO> allCarts();
    Boolean deleteByID(Integer cart_id);
    Boolean deleteByUserID(Integer user_id);
    CartDTO getByUserID(Integer user_id);
    Boolean updateByUserID(Integer user_id);
}
