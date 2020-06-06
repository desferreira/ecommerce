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

    /**
     * Momento de crianção do pagamento
     */
    @Getter @Setter
    public Instant moment;

    /**
     * Status do pagamento
     */
    @Getter @Setter
    public PaymentStatus paymentStatus;

    /**
     * Número do cartão do pagamento
     */
    @Getter @Setter
    public String cardNumber;

    /**
     * Valor do pagamento
     */
    @Getter @Setter
    public Double paymentValue;

    /**
     * Cliente associado ao pagamento
     */
    @OneToOne
    public Client client;

    /**
     * Tipo do pagamento
     */
    @Getter @Setter
    public PaymentType type;

}
