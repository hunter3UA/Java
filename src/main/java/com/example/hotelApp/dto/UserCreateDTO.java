package com.example.hotelApp.dto;


import java.util.Objects;

public class UserCreateDTO {




    public UserCreateDTO(){}
    public UserCreateDTO(String name,String email,String password){
        this.email=email;
        this.name=name;
        this.password=password;
    }

    private String name;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateDTO that = (UserCreateDTO) o;
        return name.equals(that.name) && email.equals(that.email) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password);
    }
}
