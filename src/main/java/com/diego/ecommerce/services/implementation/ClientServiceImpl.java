package com.diego.ecommerce.services.implementation;

import com.diego.ecommerce.data.entities.Addres;
import com.diego.ecommerce.data.entities.Client;
import com.diego.ecommerce.data.entities.enums.ClientStatus;
import com.diego.ecommerce.data.forms.AddresForm;
import com.diego.ecommerce.data.forms.ClientForm;
import com.diego.ecommerce.exception.HttpException;
import com.diego.ecommerce.repositories.IAddresRepository;
import com.diego.ecommerce.repositories.IClientRepository;
import com.diego.ecommerce.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientServiceImpl implements IClientService {

    Logger logger = Logger.getLogger("clientServiceImpl");

    @Autowired
    private IClientRepository repository;

    @Autowired
    private IAddresRepository addresRepository;

    @Override
    public List<Client> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> optional = this.repository.findById(id);
        if (optional.isEmpty()){
            logger.log(Level.SEVERE, String.format("Client with id [%d] is not found", id));
            throw new HttpException(String.format("Client with id [%d] is not found", id),
                    HttpStatus.NOT_FOUND, "Not found");
        }
        return optional.get();
    }

    @Override
    public Client registerClient(ClientForm form) {
        if (form == null){
            logger.log(Level.SEVERE, String.format("The form is null!"));
            throw new HttpException("This form is invalid!", HttpStatus.BAD_REQUEST, "Erro");
        }
        Client client = registerClientFromForm(form);
        this.repository.save(client);
        return client;
    }

    @Override
    public void deleteClient(Long id) {
       Client client = this.findById(id);
       client.status = ClientStatus.INACTIVE;
       this.repository.save(client);
    }

    private Client registerClientFromForm(ClientForm form){
        Client client = new Client();
        client.cpf = form.cpf;
        client.name = form.name;
        client.addres = this.registerAddres(form.addresForm);
        return client;
    }

    private Addres registerAddres(AddresForm form){
        Addres addres = new Addres();

        addres.setStreet(form.street);
        addres.setComplement(form.complement);
        addres.setNumber(form.number);
        addres.setState(form.state);
        addres.setCity(form.city);

        this.addresRepository.save(addres);

        return addres;
    }

}
