package com.diego.ecommerce.services;

import com.diego.ecommerce.data.entities.Client;
import com.diego.ecommerce.data.forms.ClientForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    List<Client> findAll();

    Client findById(Long id);

    Client registerClient(ClientForm form);

    void deleteClient(Long id);
}
