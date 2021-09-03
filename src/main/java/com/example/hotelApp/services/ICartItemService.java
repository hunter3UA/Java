package com.example.hotelApp.services;

import com.example.hotelApp.dto.AddCartItemDTO;
import com.example.hotelApp.dto.CartItemDTO;
import com.example.hotelApp.dto.RemoveCartItemDTO;

import java.util.List;

public interface ICartItemService {
    List<CartItemDTO> addItemToCart(AddCartItemDTO addCartItemDTO);
    List<CartItemDTO> removeItemFromCart(RemoveCartItemDTO removeCartItemDTO);
    List<CartItemDTO> removeByCartID(Integer cart_id);
    List<CartItemDTO> allItemsByCartID(Integer cart_id);

}
