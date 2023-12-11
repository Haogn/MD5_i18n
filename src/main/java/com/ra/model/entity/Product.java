package com.ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "product_name")
    private String productName ;
    @Column(name = "price")
    private Double price ;
    @Column(name = "image")
    private String image ;
    @ManyToOne
    @JoinColumn(name = "category_id" , referencedColumnName = "category_id")
    private Category category ;

    public Product() {
    }

    public Product(Integer id, String productName, Double price, String image, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
