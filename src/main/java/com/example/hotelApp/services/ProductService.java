package com.example.hotelApp.services;

import com.example.hotelApp.dto.AddProductDTO;
import com.example.hotelApp.dto.ProductDTO;
import com.example.hotelApp.mapper.AutoMapper;
import com.example.hotelApp.models.Manufacturer;
import com.example.hotelApp.models.Product;
import com.example.hotelApp.models.ProductSubCategory;
import com.example.hotelApp.models.Unit;
import com.example.hotelApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService{


    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UnitRepository unitRepository;

    @Autowired
    public ManufacturerRepository manufacturerRepository;

    @Autowired
    public SubCategoryRepository subCategoryRepository;

    @Autowired
    public CartItemRepository cartItemRepository;

    @Override
    public ProductDTO addProduct(AddProductDTO addProductDTO) {
        Product newProduct= new Product();
        newProduct.setId(0);
        newProduct.setProduct_name(addProductDTO.getProduct_name());
        newProduct.setProduct_price(addProductDTO.getProduct_price());
        Unit unit=unitRepository.findById(addProductDTO.getUnit_id()).get();
        newProduct.setUnit(unit);
        Manufacturer manufacturer=manufacturerRepository.findById(addProductDTO.getManufacturer_id()).get();
        newProduct.setManufacturer(manufacturer);
        ProductSubCategory productSubCategory=subCategoryRepository.findById(addProductDTO.getProduct_sub_category_id()).get();
        newProduct.setProductSubCategory(productSubCategory);
        newProduct.setDescription(addProductDTO.getDescription());
        newProduct = productRepository.save(newProduct);
        return AutoMapper.mapProduct(newProduct);
    }


    @Override
    public List<ProductDTO> allBySubCategory(Integer subCategoryID){
        List<Product> allProducts=productRepository.allBySubCategoryID(subCategoryID);

        return AutoMapper.mapListOfProducts(allProducts);

    }

    @Override
    public ProductDTO byID(Integer productID) {
        if(productRepository.existsById(productID)){
            Product product=productRepository.findById(productID).get();
            return AutoMapper.mapProduct(product);
        }
        return new ProductDTO();
    }

    @Override
    public Boolean deleteByID(Integer productID) {
        if(productRepository.existsById(productID)){
            try{
                    cartItemRepository.deleteByProductID(productID);
            }catch (Exception ex){}

            productRepository.deleteById(productID);
            return true;
        }

        return false;
    }

    @Override
    public ProductDTO updateProduct(AddProductDTO addProductDTO) {
        if(productRepository.existsById(addProductDTO.getId())){
            Product productToUpdate=productRepository.findById(addProductDTO.getId()).get();
            productToUpdate.setProduct_price(addProductDTO.getProduct_price());
            productToUpdate.setProduct_name(addProductDTO.getProduct_name());
            productToUpdate.setProductSubCategory(subCategoryRepository.findById(addProductDTO.getProduct_sub_category_id()).get());
            productToUpdate.setManufacturer(manufacturerRepository.findById(addProductDTO.getManufacturer_id()).get());
            productToUpdate.setUnit(unitRepository.findById(addProductDTO.getUnit_id()).get());
            productToUpdate.setDescription(addProductDTO.getDescription());
            productToUpdate = productRepository.save(productToUpdate);

            return AutoMapper.mapProduct(productToUpdate);

        }




        return new ProductDTO();
    }

}
