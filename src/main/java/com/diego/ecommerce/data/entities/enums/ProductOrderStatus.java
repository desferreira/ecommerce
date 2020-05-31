package com.diego.ecommerce.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum ProductOrderStatus {

    PENDING(0),
    ACTIVE(1),
    CANCELED(2);

    @Getter
    @Setter
    private int code;

    ProductOrderStatus(int code) {
        this.code = code;
    }

    public static ProductOrderStatus valueOf(int code) {
        for (ProductOrderStatus e : ProductOrderStatus.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valide type", code));
    }

}
