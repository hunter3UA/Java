package com.example.hotelApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="units")
public class Unit {

    public Unit(){}
    public Unit(Integer id,String unit_name){
        this.id=id;
        this.unit_name=unit_name;

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String unit_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return id.equals(unit.id) && unit_name.equals(unit.unit_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unit_name);
    }
}
