package com.example.hotelApp.dto;

import com.example.hotelApp.models.Product;
import com.example.hotelApp.models.ShoppingCart;

public class CartItemDTO {

    public CartItemDTO(Integer id, Product product, Double quantity,Integer cartID,Double total_sum){
        this.id=id;
        this.product=product;
        this.quantity=quantity;
        this.cartID=cartID;
        this.total_sum=total_sum;

    }

    private Integer id;
    private Product product;
    private Double quantity;
    private Double total_sum;
    private Integer cartID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotal_sum() {
        return quantity*product.getProduct_price();
    }

    public Integer getCartID() {
        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }
}
