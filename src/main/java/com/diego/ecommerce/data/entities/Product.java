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

    /**
     * Nome do produto
     */
    @Getter @Setter
    public String name;

    /**
     * Descrição do produto
     */
    @Getter @Setter
    public String description;

    /**
     * Preço do produto
     */
    @Getter @Setter
    public Double price;

    /**
     * URL da imagem do produto
     */
    @Getter @Setter
    public String productImage;

    /**
     * Categoria do produto
     */
    @Getter @Setter
    public CategoryType categoryType;

    /**
     * Quantidade do produto em estoque
     */
    @Getter @Setter
    public Integer productQuantity;

    /**
     * Flag indicativa se o produto é um dos mais vendidos
     */
    @Getter @Setter
    public Boolean isTopSelling;

    /**
     * Flag indicativa se o produto está em promoção
     */
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
