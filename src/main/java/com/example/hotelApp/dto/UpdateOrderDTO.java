package com.example.hotelApp.dto;

import com.example.hotelApp.models.OrderStatus;

import java.time.LocalDate;

public class UpdateOrderDTO {


    private Integer id;

    private Integer orderStatus;

    private Boolean is_payed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getIs_payed() {
        return is_payed;
    }

    public void setIs_payed(Boolean is_payed) {
        this.is_payed = is_payed;
    }
}
