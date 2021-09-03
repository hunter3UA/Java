package com.example.hotelApp.dto;

import com.example.hotelApp.models.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

public class CartDTO {
    public CartDTO(){}
    public CartDTO(Integer id, Integer user_id, LocalDate registered_at){
        this.id=id;
        this.user_id=user_id;
        this.registered_at=registered_at;

    }


    private Integer id;
    private Integer user_id;
    private LocalDate registered_at;




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

    public LocalDate getRegistered_at() {
        return registered_at;
    }

    public void setRegistered_at(LocalDate registered_at) {
        this.registered_at = registered_at;
    }


}
