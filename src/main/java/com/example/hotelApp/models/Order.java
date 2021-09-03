package com.example.hotelApp.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {


    public Order(){}
    public Order(Integer id,User user,Boolean is_payed,LocalDate date_of_order,OrderStatus orderStatus,Double order_sum){
        this.id=id;
        this.orderStatus=orderStatus;
        this.date_of_order=date_of_order;
        this.is_payed=is_payed;
        this.user=user;
        this.order_sum=order_sum;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


    private Double order_sum;


    @ManyToOne
    @JoinColumn(name = "order_status_id",referencedColumnName = "id")
    private OrderStatus orderStatus;

    private Boolean is_payed;


    private LocalDate date_of_order;

    public Double getOrder_sum() {
        return order_sum;
    }

    public void setOrder_sum(Double order_sum) {
        this.order_sum = order_sum;
    }

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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(user, order.user) && Objects.equals(order_sum, order.order_sum) && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(is_payed, order.is_payed) && Objects.equals(date_of_order, order.date_of_order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, order_sum, orderStatus, is_payed, date_of_order);
    }
}
