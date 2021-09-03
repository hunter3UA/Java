package com.example.hotelApp.dto;

import com.example.hotelApp.models.Manufacturer;
import com.example.hotelApp.models.ProductSubCategory;
import com.example.hotelApp.models.Unit;

import javax.persistence.*;

public class ProductDTO {


    public ProductDTO(){}
    public ProductDTO(Integer id,Unit unit, ProductSubCategory productSubCategory,Manufacturer manufacturer,String product_name,Double product_price,String description){
        this.id=id;
        this.unit=unit;
        this.productSubCategory=productSubCategory;
        this.manufacturer=manufacturer;
        this.product_name=product_name;
        this.product_price=product_price;
        this.description=description;
    }



    private Integer id;
    private Unit unit;
    private ProductSubCategory productSubCategory;
    private Manufacturer manufacturer;
    private String product_name;
    private Double product_price;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public ProductSubCategory getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(ProductSubCategory productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
