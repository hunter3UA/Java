package com.example.hotelApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_statuses")
public class OrderStatus {


    public OrderStatus(){}
    public OrderStatus(Integer id, String status_name){
        this.id=id;
        this.status_name=status_name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String status_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(status_name, that.status_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status_name);
    }
}
