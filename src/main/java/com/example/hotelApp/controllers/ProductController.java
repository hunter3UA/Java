package com.example.hotelApp.controllers;

import com.example.hotelApp.dto.AddProductDTO;
import com.example.hotelApp.dto.ProductDTO;
import com.example.hotelApp.models.Product;
import com.example.hotelApp.services.IProductService;
import com.example.hotelApp.services.ProductService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public IProductService productService;


    @PostMapping("/product")
    public ProductDTO addProduct(@RequestBody AddProductDTO addProductDTO){
        return productService.addProduct(addProductDTO);
    }

    @GetMapping("/product/subCategory/{subCategoryID}")
    public List<ProductDTO> getAllProductsBySubCategory(@PathVariable(name = "subCategoryID")Integer subCategoryID){
        return productService.allBySubCategory(subCategoryID);
    }
    @GetMapping("/product/{productID}")
    public ProductDTO getByID(@PathVariable(name = "productID")Integer productID){
        return productService.byID(productID);
    }
    @DeleteMapping("/product/{productID}")
    public Boolean deleteByID(@PathVariable(name="productID")Integer productID){
        return productService.deleteByID(productID);

    }
    @PutMapping("/product")
    public ProductDTO updateProduct(@RequestBody AddProductDTO addProductDTO){
        return productService.updateProduct(addProductDTO);

    }

}
