package com.diego.ecommerce.data.entities;

import com.diego.ecommerce.data.entities.enums.ClientStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    public Long id;

    @Getter @Setter
    public String name;

    @Getter @Setter
    public String cpf;

    public ClientStatus status;

    public Client(){
        this.status = ClientStatus.ACTIVE;
    }

    public Client(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

}
