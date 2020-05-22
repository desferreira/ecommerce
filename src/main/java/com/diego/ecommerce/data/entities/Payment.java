package com.diego.ecommerce.data.entities;

import com.diego.ecommerce.data.entities.enums.PaymentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Payment {

    @Id @Getter @Setter
    public Long id;

    @Getter @Setter
    public PaymentStatus status;


}
