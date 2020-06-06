package com.diego.ecommerce.services;

import com.diego.ecommerce.data.entities.Payment;
import com.diego.ecommerce.data.forms.PaymentForm;
import org.springframework.stereotype.Service;

@Service
public interface IPaymentService {

    /**
     * Método responsável por bucar um pagamento a partir do ID
     * @param id Id do pagamento
     * @return
     */
    Payment findById(Long id);

    /**
     * Método responsável por criar um pagamento a partir de um formulário
     * @param form Formulário com dados de pagamento
     * @return
     */
    Payment registerPayment(PaymentForm form);

}
