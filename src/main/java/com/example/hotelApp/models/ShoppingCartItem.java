package com.example.hotelApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shopping_cart_items")
public class ShoppingCartItem {
    public ShoppingCartItem(){}

    public ShoppingCartItem(Integer id,Product product,Double quantity,ShoppingCart cart){
        this.id=id;
        this.product=product;
        this.quantity=quantity;
        this.cart=cart;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="shopping_cart_id",referencedColumnName = "id")
    private ShoppingCart cart;


    private Double quantity;
    private Double item_price;

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

    public Double getItem_price() {
        return item_price;
    }

    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(cart, that.cart) && Objects.equals(quantity, that.quantity) && Objects.equals(item_price, that.item_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, cart, quantity, item_price);
    }
}
