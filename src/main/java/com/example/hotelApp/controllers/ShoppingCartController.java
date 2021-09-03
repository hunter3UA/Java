package com.example.hotelApp.controllers;

import com.example.hotelApp.dto.CartDTO;
import com.example.hotelApp.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {


    @Autowired
    public ICartService cartService;


    @GetMapping("/cart")
    public List<CartDTO> allCarts(){
        return cartService.allCarts();
    }

    @DeleteMapping("/cart/{cart_id}")
    public Boolean deleteByID(@PathVariable(name = "cart_id")Integer cart_id){
        return cartService.deleteByID(cart_id);
    }


    @GetMapping("/cart/{user_id}")
    public CartDTO byUserID(@PathVariable(name="user_id")Integer user_id){
        return cartService.getByUserID(user_id);
    }


    @PutMapping("/cart/{user_id}")
    public Boolean updateByUserID(@PathVariable(name ="user_id")Integer user_id){
        return null;
    }




}



















