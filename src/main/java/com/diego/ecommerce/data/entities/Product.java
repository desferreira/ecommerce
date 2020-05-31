package com.diego.ecommerce.data.entities;

import com.diego.ecommerce.data.entities.enums.CategoryType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    public Long id;

    @Getter @Setter
    public String name;

    @Getter @Setter
    public String description;

    @Getter @Setter
    public Double price;

    @Getter @Setter
    public String productImage;

    @Getter @Setter
    public CategoryType categoryType;

    @Getter @Setter
    public Integer productQuantity;

    @Getter @Setter
    public Boolean isTopSelling;

    @Getter @Setter
    public Boolean isTopDeal;

    public Product(){
        this.isTopDeal = false;
        this.isTopSelling = false;
        this.productQuantity = 0;
    }

    public Product(String name, String description, Double price, String productImage, CategoryType categoryType){
        this.name = name;
        this.description = description;
        this.price = price;
        this.productImage = productImage;
        this.categoryType = categoryType;
    }
}
