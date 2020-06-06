package com.diego.ecommerce.data.entities;

import com.diego.ecommerce.data.entities.enums.ProductOrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class ProductOrder {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * Instante de criação da ordem
     */
    @Getter @Setter
    public Instant creationTime;

    /**
     * Pagamento associado à ordem
     */
    @OneToOne
    public Payment payment;

    /**
     * Lista de produtos da ormde
     */
    @OneToMany
    public List<Product> productList;

    /**
     * Status da ordem
     */
    @Getter @Setter
    public ProductOrderStatus status;

    /**
     * Cliente resposável pela ordem
     */
    @OneToOne
    public Client client;

    public ProductOrder(){
        this.creationTime = Instant.now();
        this.status = ProductOrderStatus.PENDING;
    }


    public void addProduct(Product product){
        this.productList.add(product);
    }

    public void removeProduct(Product product){
        this.productList.remove(product);
    }


}
