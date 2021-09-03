package com.example.hotelApp.models;


import javassist.bytecode.ByteArray;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    public User(){}
    public User(Integer id,String email,String name,String password_hash,Integer hash_iterations){
        this.id=id;
        this.email=email;
        this.name=name;
        this.password_hash=password_hash;
        this.hash_iterations=hash_iterations;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String name;

    private String password_hash;



    private Integer hash_iterations;

    private Boolean is_deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Integer getHash_iterations() {
        return hash_iterations;
    }

    public void setHash_iterations(Integer hash_iterations) {
        this.hash_iterations = hash_iterations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(password_hash, user.password_hash) && Objects.equals(hash_iterations, user.hash_iterations) && Objects.equals(is_deleted, user.is_deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, password_hash, hash_iterations, is_deleted);
    }
}
