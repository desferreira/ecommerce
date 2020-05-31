package com.diego.ecommerce.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum PaymentType {

    CASH(0),
    DEBIT(1),
    CREDIT(2);

    @Getter
    @Setter
    private int code;

    PaymentType(int code) {
        this.code = code;
    }

    public static PaymentType valueOf(int code) {
        for (PaymentType e : PaymentType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valide type", code));
    }
}
