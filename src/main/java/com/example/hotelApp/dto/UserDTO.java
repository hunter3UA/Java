package com.example.hotelApp.dto;

import java.util.Objects;

public class UserDTO {

    public UserDTO(){}
    public UserDTO(Integer id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;

    }

    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id.equals(userDTO.id) && name.equals(userDTO.name) && email.equals(userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
