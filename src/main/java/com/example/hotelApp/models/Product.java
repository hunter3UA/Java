package com.example.hotelApp.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    public Product(){}
    public Product(Integer id, Unit unit,ProductSubCategory productSubCategory,Manufacturer manufacturer,String product_name,Double product_price,String description){
        this.id=id;
        this.unit=unit;
        this.productSubCategory=productSubCategory;
        this.manufacturer=manufacturer;
        this.product_name=product_name;
        this.product_price=product_price;
        this.description=description;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "unit_id",referencedColumnName = "id")
    private Unit unit;


    @ManyToOne
    @JoinColumn(name = "product_subcategory_id",referencedColumnName = "id")
    private ProductSubCategory productSubCategory;


    @ManyToOne
    @JoinColumn(name = "manufacturer_id",referencedColumnName = "id")
    private Manufacturer manufacturer;


    private String product_name;
    private Double product_price;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public ProductSubCategory getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(ProductSubCategory productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && unit.equals(product.unit) && productSubCategory.equals(product.productSubCategory) && manufacturer.equals(product.manufacturer) && product_name.equals(product.product_name) && product_price.equals(product.product_price) && description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unit, productSubCategory, manufacturer, product_name, product_price, description);
    }
}
/* id serial PRIMARY KEY NOT NULL,
    product_name VARCHAR(500) NOT NULL,
    product_price MONEY NOT NULL,
    description VARCHAR(1000),
    product_subcategory_id serial NOT NULL,
    unit_id serial NOT NULL,
    manufacturer_id serial NOT NULL*/