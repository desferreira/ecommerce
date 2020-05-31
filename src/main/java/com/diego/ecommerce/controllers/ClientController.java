package com.diego.ecommerce.controllers;

import com.diego.ecommerce.data.entities.Client;
import com.diego.ecommerce.data.forms.ClientForm;
import com.diego.ecommerce.repositories.IClientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientRepository repository;

    @PostMapping
    public ResponseEntity<Client> registerClient(ClientForm form){
        Client client = new Client();
        client.name = form.name;
        client.CPF = form.CPF;
        this.repository.save(client);
        return ResponseEntity.ok().body(client);
    }

}
