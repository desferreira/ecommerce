package com.diego.ecommerce.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Addres {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private long Id;

    /**
     * Enderçeo do cliente
     */
    @Getter @Setter
    private String street;

    /**
     * Número da casa
     */
    @Getter @Setter
    private String number;

    /**
     * Complemento do endereço
     */
    @Getter @Setter
    private String complement;

    /**
     * Estado do endereço
     */
    @Getter @Setter
    private String state;

    /**
     * Cidade do endereço
     */
    @Getter @Setter
    private String city;


}
