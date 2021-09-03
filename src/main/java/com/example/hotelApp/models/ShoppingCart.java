package com.example.hotelApp.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="shopping_carts")
public class ShoppingCart {
    public ShoppingCart(){}
    public ShoppingCart(Integer id,User user, LocalDate registered_at){
        this.id=id;
        this.user=user;
        this.registered_at=registered_at;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    private LocalDate registered_at;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getRegistered_at() {
        return registered_at;
    }

    public void setRegistered_at(LocalDate registered_at) {
        this.registered_at = registered_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart cart = (ShoppingCart) o;
        return Objects.equals(id, cart.id) && Objects.equals(user, cart.user) && Objects.equals(registered_at, cart.registered_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, registered_at);
    }
}
