package com.example.hotelApp.repository;

import com.example.hotelApp.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    @Query(value = "SELECT * FROM public.products WHERE  product_subcategory_id=?1",nativeQuery = true)
    List<Product> allBySubCategoryID(Integer subCategoryID);
}
