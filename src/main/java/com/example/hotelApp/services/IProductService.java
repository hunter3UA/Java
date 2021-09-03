package com.example.hotelApp.services;

import com.example.hotelApp.dto.AddProductDTO;
import com.example.hotelApp.dto.ProductDTO;
import com.example.hotelApp.models.Product;

import java.util.List;

public interface IProductService {
    ProductDTO addProduct(AddProductDTO addProductDTO);
    List<ProductDTO> allBySubCategory(Integer subCategoryID);
    ProductDTO byID(Integer productID);
    Boolean deleteByID(Integer productID);
    ProductDTO updateProduct(AddProductDTO addProductDTO);


}
