package com.example.hotelApp.repository;

import com.example.hotelApp.models.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<ProductCategory,Integer> {
}
