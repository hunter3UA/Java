package com.example.hotelApp.services;

import com.example.hotelApp.dto.AddCartItemDTO;
import com.example.hotelApp.dto.CartItemDTO;
import com.example.hotelApp.dto.RemoveCartItemDTO;
import com.example.hotelApp.mapper.AutoMapper;
import com.example.hotelApp.models.Product;
import com.example.hotelApp.models.ShoppingCart;
import com.example.hotelApp.models.ShoppingCartItem;
import com.example.hotelApp.models.User;
import com.example.hotelApp.repository.CartItemRepository;
import com.example.hotelApp.repository.CartRepository;
import com.example.hotelApp.repository.ProductRepository;
import com.example.hotelApp.repository.UserRepository;
import com.example.hotelApp.services.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartItemService implements ICartItemService {

    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ProductRepository productRepository;


    @Autowired
    public CartItemRepository cartItemRepository;


    @Override
    public List<CartItemDTO> addItemToCart(AddCartItemDTO addCartItemDTO) {
        ShoppingCart userCart=cartRepository.byUserID(addCartItemDTO.getUserID());
        if(userRepository.existsById(addCartItemDTO.getUserID()) &&  userRepository.findById(addCartItemDTO.getUserID()).get().getIs_deleted()==false){
            if(userCart==null && userRepository.existsById(addCartItemDTO.getUserID())){
                userCart=createCart(addCartItemDTO);
                userCart=cartRepository.save(userCart);

            }
            ShoppingCartItem checkItem=cartItemRepository.getByProductAndCartID(addCartItemDTO.getProductId(),userCart.getId());
            if(productRepository.existsById(addCartItemDTO.getProductId())) {


                if (checkItem == null) {
                    checkItem = new ShoppingCartItem();

                    checkItem.setProduct(productRepository.findById(addCartItemDTO.getProductId()).get());
                    checkItem.setCart(userCart);
                    checkItem.setQuantity(addCartItemDTO.getQuantity());
                    checkItem.setItem_price(productRepository.findById(addCartItemDTO.getProductId()).get().getProduct_price());

                } else {
                    checkItem.setQuantity(checkItem.getQuantity() + addCartItemDTO.getQuantity());
                }

                cartItemRepository.save(checkItem);
                return AutoMapper.mapListOfItems(cartItemRepository.allByCartID(userCart.getId()));
            }
        }
        return new ArrayList<CartItemDTO>();

    }

    @Override
    public  List<CartItemDTO> removeItemFromCart(RemoveCartItemDTO removeCartItemDTO) {
        if(userRepository.existsById(removeCartItemDTO.getUserID()) && userRepository.findById(removeCartItemDTO.getUserID()).get().getIs_deleted()==false) {
            ShoppingCart userCart = cartRepository.byUserID(removeCartItemDTO.getUserID());
            if (userCart != null) {
                ShoppingCartItem checkItem = cartItemRepository.getByProductAndCartID(removeCartItemDTO.getProductId(), userCart.getId());
                if (checkItem != null) {
                    if (removeCartItemDTO.getQuantity() < checkItem.getQuantity()) {
                        checkItem.setQuantity(checkItem.getQuantity() - removeCartItemDTO.getQuantity());
                        cartItemRepository.save(checkItem);
                    } else {
                        cartItemRepository.deleteById(checkItem.getId());
                    }

                    return AutoMapper.mapListOfItems(cartItemRepository.allByCartID(userCart.getId()));
                }
            }
        }


        return new ArrayList<CartItemDTO>();
    }

    @Override
    public List<CartItemDTO> removeByCartID(Integer cart_id) {
        try{
            cartItemRepository.deleteAllByCartID(cart_id);
        }catch (Exception ex){

        }
        return AutoMapper.mapListOfItems(cartItemRepository.allByCartID(cart_id));
    }

    @Override
    public List<CartItemDTO> allItemsByCartID(Integer cart_id) {
        try{
            List<ShoppingCartItem> allItems=cartItemRepository.allByCartID(cart_id);

            return AutoMapper.mapListOfItems(allItems);

        }catch (Exception ex){
            String msg=ex.getMessage();
            return new ArrayList<CartItemDTO>();
        }


    }


    private ShoppingCart createCart(AddCartItemDTO addCartItemDTO){
        ShoppingCart newCart=new ShoppingCart(0,userRepository.findById(addCartItemDTO.getUserID()).get(), LocalDate.now());
        return newCart;
    }


}