package com.diego.ecommerce.data.entities;

import com.diego.ecommerce.data.entities.enums.ClientStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    public Long id;

    /**
     * Nome do cliente
     */
    @Getter @Setter
    public String name;

    /**
     * CPF do cliente
     */
    @Getter @Setter
    public String cpf;

    /**
     * Status do cliente
     */
    @Getter @Setter
    public ClientStatus status;

    /**
     * Dados de endereço do cliente
     */
    @OneToOne
    public Addres addres;

    public Client(){
        this.status = ClientStatus.ACTIVE;
    }

    public Client(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

}
