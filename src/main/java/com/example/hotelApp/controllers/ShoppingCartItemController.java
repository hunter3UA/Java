package com.example.hotelApp.controllers;

import com.example.hotelApp.dto.AddCartItemDTO;
import com.example.hotelApp.dto.CartItemDTO;
import com.example.hotelApp.dto.RemoveCartItemDTO;
import com.example.hotelApp.services.ICartItemService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingCartItemController {


    @Autowired
    public ICartItemService cartItemService;

    @PostMapping("/item")
    public  List<CartItemDTO> addItemToCart(@RequestBody AddCartItemDTO addCartItemDTO){
        return cartItemService.addItemToCart(addCartItemDTO);
    }

    @DeleteMapping("/item")
    public List<CartItemDTO> removeItemFromCart(@RequestBody RemoveCartItemDTO removeCartItemDTO) {
        return cartItemService.removeItemFromCart(removeCartItemDTO);
    }

    @GetMapping("/item/{cart_id}")
    public List<CartItemDTO> byCartID(@PathVariable(name = "cart_id")Integer cart_id){
        return  cartItemService.allItemsByCartID(cart_id);

    }
    @DeleteMapping("/item/{cart_id}")
    public List<CartItemDTO> deleteByCartID(@PathVariable(name = "cart_id")Integer cart_id){
        return cartItemService.removeByCartID(cart_id);
    }



}
