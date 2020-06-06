package com.diego.ecommerce.data.forms;


import com.sun.istack.NotNull;

public class AddresForm {

    /**
     * Endereço do cliente
     */
    @NotNull
    public String street;

    /**
     * Número da casa
     */
    @NotNull
    public String number;

    /**
     * Compelemento do endereço (opcional)
     */
    public String complement;

    /**
     * Estado do endereço
     */
    @NotNull
    public String state;

    /**
     * Cidade do endereço
     */
    @NotNull
    public String city;

}
