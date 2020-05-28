package com.diego.ecommerce.services.implementation;

import com.diego.ecommerce.data.entities.Client;
import com.diego.ecommerce.data.entities.Payment;
import com.diego.ecommerce.data.entities.enums.PaymentStatus;
import com.diego.ecommerce.data.forms.PaymentForm;
import com.diego.ecommerce.exception.HttpException;
import com.diego.ecommerce.repositories.IClientRepository;
import com.diego.ecommerce.repositories.IPaymentRepository;
import com.diego.ecommerce.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PaymentServiceImpl implements IPaymentService {

    Logger logger = Logger.getLogger("paymentServiceImpl");

    @Autowired
    private IPaymentRepository repository;

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Payment findById(Long id) {
        logger.log(Level.INFO, String.format("Finding the payment with id [%d]", id));
        Optional<Payment> payment = this.repository.findById(id);

        if (payment.isEmpty()){
            logger.log(Level.SEVERE, String.format("Payment with id [%d] is not found", id));
            throw new HttpException(String.format("Payment with id [%d] is not found", id),
                    HttpStatus.NOT_FOUND, "Not found");
        }

        return payment.get();

    }

    @Override
    public Payment registerPayment(PaymentForm form) {
        Payment payment = this.createPaymentFromForm(form);

        logger.log(Level.INFO, String.format("Saving the payment with value [%d]", payment.paymentValue));

        this.repository.save(payment);

        return payment;
    }

    private Payment createPaymentFromForm(PaymentForm form) {
        Payment payment = new Payment();

        payment.cardNumber = form.cardNUmber;
        payment.moment = Instant.now();
        payment.paymentStatus = PaymentStatus.PROCESSING;
        payment.paymentValue = form.paymentValue;

        Optional<Client> optionalClient = this.clientRepository.findById(form.clientId);

        if (optionalClient.isEmpty()){
            throw new HttpException(String.format("Client with id [%d] is not found", form.clientId),
                    HttpStatus.NOT_FOUND, "Not found");
        }

        payment.client = optionalClient.get();

        return payment;
    }
}
