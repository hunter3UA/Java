package com.example.hotelApp.dto;

import com.example.hotelApp.models.OrderStatus;
import com.example.hotelApp.models.User;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDTO {


    public OrderDTO(){}
    public OrderDTO(Integer id, Integer user_id, LocalDate date_of_order, OrderStatus orderStatus,Boolean is_payed,Double order_sum){
        this.id=id;
        this.orderStatus=orderStatus;
        this.date_of_order=date_of_order;
        this.is_payed=is_payed;
        this.user_id=user_id;
        this.order_sum=order_sum;
    }


    private Integer id;


    private Integer user_id;

    private OrderStatus orderStatus;





    private Double order_sum;

    private Boolean is_payed;


    private LocalDate date_of_order;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrder_sum() {
        return order_sum;
    }

    public void setOrder_sum(Double order_sum) {
        this.order_sum = order_sum;
    }

    public Boolean getIs_payed() {
        return is_payed;
    }

    public void setIs_payed(Boolean is_payed) {
        this.is_payed = is_payed;
    }

    public LocalDate getDate_of_order() {
        return date_of_order;
    }

    public void setDate_of_order(LocalDate date_of_order) {
        this.date_of_order = date_of_order;
    }
}
