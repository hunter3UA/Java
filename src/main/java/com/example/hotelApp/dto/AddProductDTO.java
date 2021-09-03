package com.example.hotelApp.dto;

import com.example.hotelApp.models.Manufacturer;
import com.example.hotelApp.models.ProductSubCategory;
import com.example.hotelApp.models.Unit;

public class AddProductDTO {
    private Integer id;
    private Integer unit_id;
    private Integer product_sub_category_id;
    private Integer manufacturer_id;
    private String product_name;
    private Double product_price;
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Integer unit_id) {
        this.unit_id = unit_id;
    }

    public Integer getProduct_sub_category_id() {
        return product_sub_category_id;
    }

    public void setProduct_sub_category_id(Integer product_sub_category_id) {
        this.product_sub_category_id = product_sub_category_id;
    }

    public Integer getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Integer manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
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
