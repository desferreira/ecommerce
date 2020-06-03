package com.diego.ecommerce.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum ClientStatus {
    PENDING(0),
    ACTIVE(1),
    INACTIVE(2);

    @Getter
    @Setter
    private int code;

    ClientStatus(int code) {
        this.code = code;
    }

    public static ClientStatus valueOf(int code) {
        for (ClientStatus e : ClientStatus.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valide type", code));
    }
}
