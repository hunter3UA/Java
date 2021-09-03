package com.example.hotelApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_categories")
public class ProductCategory {
    public ProductCategory(){ }
    public ProductCategory(Integer id,String product_category_name){
        this.id=id;
        this.product_category_name=product_category_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String product_category_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_category_name() {
        return product_category_name;
    }

    public void setProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return id.equals(that.id) && product_category_name.equals(that.product_category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_category_name);
    }
}
