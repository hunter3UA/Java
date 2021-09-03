package com.example.hotelApp.repository;

import com.example.hotelApp.models.ShoppingCart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<ShoppingCart,Integer> {
    @Query(value = "SELECT * FROM public.shopping_carts WHERE user_id=?",nativeQuery = true)
    ShoppingCart byUserID(Integer user_id);

    @Query(value ="DELETE FROM public.shopping_carts WHERE user_id=?",nativeQuery = true)
    ShoppingCart deleteByUserID(Integer user_id);
}
