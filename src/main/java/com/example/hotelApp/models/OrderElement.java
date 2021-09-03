package com.example.hotelApp.models;

import javax.persistence.*;
import java.util.Objects;



@Entity
@Table(name = "order_elements")
public class OrderElement {

    public OrderElement(){}

    public OrderElement(Integer id,Order order,String product_name){
        this.id=id;
        this.order=order;
        this.product_name=product_name;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;


    private String product_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderElement that = (OrderElement) o;
        return Objects.equals(id, that.id) && Objects.equals(order, that.order) && Objects.equals(product_name, that.product_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, product_name);
    }
}
