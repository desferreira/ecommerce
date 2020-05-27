package com.diego.ecommerce.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@Entity
public class ProductOrder {


    @Getter
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Getter @Setter
    private Instant moment;

    @OneToOne
    private Payment payment;

    @OneToMany
    private List<Product> productList;

}
