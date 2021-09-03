package com.example.hotelApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    public Manufacturer(){}
    public Manufacturer(Integer id,String manufacturer_name){
        this.id=id;
        this.manufacturer_name=manufacturer_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String manufacturer_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return id.equals(that.id) && manufacturer_name.equals(that.manufacturer_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufacturer_name);
    }
}
