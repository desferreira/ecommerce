package com.diego.ecommerce.data.forms;

import com.sun.istack.NotNull;

public class ClientForm {

    /**
     * Nome do cliente
     */
    @NotNull
    public String name;

    /**
     * CPF do cliente
     */
    @NotNull
    public String cpf;

    /**
     * Formulário com dados de endereço do cliente
     */
    @NotNull
    public AddresForm addresForm;
}
