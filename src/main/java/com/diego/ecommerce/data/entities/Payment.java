package com.diego.ecommerce.data.entities;

import com.diego.ecommerce.data.entities.enums.PaymentStatus;
import com.diego.ecommerce.data.entities.enums.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
public class Payment {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Getter @Setter
    public PaymentType type;

}
