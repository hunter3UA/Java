package com.example.hotelApp.repository;

import com.example.hotelApp.models.ProductSubCategory;
import org.springframework.data.repository.CrudRepository;

public interface SubCategoryRepository extends CrudRepository<ProductSubCategory,Integer> {
}
