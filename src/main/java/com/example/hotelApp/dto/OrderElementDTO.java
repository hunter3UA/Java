package com.example.hotelApp.dto;

import com.example.hotelApp.models.Order;

import javax.persistence.*;

public class OrderElementDTO {
    public OrderElementDTO(){}

    public OrderElementDTO(Integer id, Integer order_id, String product_name){
        this.id=id;
        this.order_id=order_id;
        this.product_name=product_name;

    }

    private Integer id;
    private Integer order_id;
    private String product_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
