package com.diego.ecommerce.data.entities.enums;

import lombok.Getter;
import lombok.Setter;

public enum CategoryType {

    PERIFERIC(0),
    MONITOR(1),
    DESKTOP(2),
    NOTEBOOKS(3);

    @Getter
    @Setter
    private int code;

    CategoryType(int code){
        this.code = code;
    }

    public static CategoryType valueOf(int code){
        for (CategoryType e : CategoryType.values()){
            if (e.getCode() == code){
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("The code %d is not a valide type", code));
    }

}
