package com.example.hotelApp.repository;

import com.example.hotelApp.models.ShoppingCartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CartItemRepository extends CrudRepository<ShoppingCartItem,Integer> {


    @Query(value = "SELECT*FROM public.shopping_cart_items WHERE product_id=?1 AND shopping_cart_id=?2",nativeQuery = true)
    ShoppingCartItem getByProductAndCartID(Integer product_id,Integer shopping_cart_id);

    @Query(value="SELECT *FROM public.shopping_cart_items WHERE shopping_cart_id=?",nativeQuery = true)
    ArrayList<ShoppingCartItem> allByCartID(Integer shopping_cart_id);


    @Query(value = "DELETE FROM public.shopping_cart_items WHERE shopping_cart_id=?",nativeQuery = true)
    void deleteAllByCartID(Integer shopping_cart_id);

    @Query(value = "DELETE FROM public.shopping_cart_items WHERE product_id=?",nativeQuery = true)
    Boolean deleteByProductID(Integer product_id);
}
