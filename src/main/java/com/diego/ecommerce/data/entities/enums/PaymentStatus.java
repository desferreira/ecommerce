package com.diego.ecommerce.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum PaymentStatus {

    PAYED(2),
    PROCESSING(1),
    REFUSE(0);

    @Getter
    @Setter
    private int code;

    PaymentStatus(int code) {
        this.code = code;
    }

    public static PaymentStatus valueOf(int code) {
        for (PaymentStatus e : PaymentStatus.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valide type", code));
    }


}
