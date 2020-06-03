package com.diego.ecommerce.controllers;

import com.diego.ecommerce.data.entities.Client;
import com.diego.ecommerce.data.forms.ClientForm;
import com.diego.ecommerce.repositories.IClientRepository;
import com.diego.ecommerce.services.IClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    @Qualifier(value = "clientServiceImpl")
    private IClientService clientService;

    @PostMapping
    public ResponseEntity<Client> registerClient(@RequestBody ClientForm form){
        Client client = this.clientService.registerClient(form);
        return ResponseEntity.ok().body(client);
    }

}
