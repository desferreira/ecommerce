package com.diego.ecommerce.data.entities;

import com.diego.ecommerce.data.entities.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
public class Payment {

    @Id @Getter
    public Long id;

    @Getter @Setter
    public Instant moment;

    @Getter @Setter
    public PaymentStatus paymentStatus;

    @Getter @Setter
    public String cardNumber;

    @Getter @Setter
    public Double paymentValue;

    @OneToOne
    public Client client;

}
