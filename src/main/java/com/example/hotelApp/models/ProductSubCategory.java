package com.example.hotelApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_sub_categories")
public class ProductSubCategory {

    public ProductSubCategory(){}
    public ProductSubCategory(Integer id,ProductCategory productCategory,String product_sub_category_name){
        this.id=id;
        this.productCategory=productCategory;
        this.product_sub_category_name=product_sub_category_name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne
    @JoinColumn(name = "product_category_id",referencedColumnName = "id")
    private ProductCategory productCategory;

    private String product_sub_category_name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProduct_sub_category_name() {
        return product_sub_category_name;
    }

    public void setProduct_sub_category_name(String product_sub_category_name) {
        this.product_sub_category_name = product_sub_category_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSubCategory that = (ProductSubCategory) o;
        return id.equals(that.id) && productCategory.equals(that.productCategory) && product_sub_category_name.equals(that.product_sub_category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productCategory, product_sub_category_name);
    }
}