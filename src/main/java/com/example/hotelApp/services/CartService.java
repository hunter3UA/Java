package com.example.hotelApp.services;


import com.example.hotelApp.dto.CartDTO;
import com.example.hotelApp.dto.CartItemDTO;
import com.example.hotelApp.mapper.AutoMapper;
import com.example.hotelApp.models.ShoppingCart;
import com.example.hotelApp.models.ShoppingCartItem;
import com.example.hotelApp.repository.CartItemRepository;
import com.example.hotelApp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    public CartRepository cartRepository;


    @Autowired
    public CartItemRepository cartItemRepository;


    @Autowired
    public ICartItemService cartItemService;

    @Override
    public List<CartDTO> allCarts() {

        ArrayList<ShoppingCart> carts=(ArrayList<ShoppingCart>) cartRepository.findAll();
        return AutoMapper.mapListOfCarts(carts);
    }

    @Override
    public Boolean deleteByID(Integer cart_id) {
        if(cartRepository.existsById(cart_id)){

            cartItemService.removeByCartID(cart_id);


            cartRepository.deleteById(cart_id);
            return true;
        }


        return false;
    }

    @Override
    public Boolean deleteByUserID(Integer user_id) {

       ShoppingCart cart=cartRepository.byUserID(user_id);
       if(cart!=null){
           cartItemService.removeByCartID(cart.getId());
           try{
               cartRepository.deleteByUserID(user_id);
           }catch (Exception ex){}

           return true;
       }
       return false;
    }

    @Override
    public CartDTO getByUserID(Integer user_id) {
        ShoppingCart cartByUserID=cartRepository.byUserID(user_id);
        if(cartByUserID!=null){
            return AutoMapper.mapCart(cartByUserID);
        }

        return new CartDTO();
    }

    @Override
    public Boolean updateByUserID(Integer user_id) {
        ShoppingCart cartByUserID=cartRepository.byUserID(user_id);
        if(cartByUserID!=null){


        }
        return false;
    }


}
