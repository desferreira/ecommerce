package com.diego.ecommerce.services;

import com.diego.ecommerce.data.entities.Client;
import com.diego.ecommerce.data.forms.ClientForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    /**
     * Método responsável por os clientes na base
     * @return
     */
    List<Client> findAll();

    /**
     * Método responsável por retornar um cliente a partir do ID
     * @param id Id do cliente
     * @return
     */
    Client findById(Long id);

    /**
     * Método responsável por registar um cliente na base
     * @param form Formulário contendo os dados do cliente
     * @return
     */
    Client registerClient(ClientForm form);

    /**
     * Método responsável por deletar um cliente da base
     * @param id
     */
    void deleteClient(Long id);
}
