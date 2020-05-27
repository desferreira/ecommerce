package com.diego.ecommerce.services;

import com.diego.ecommerce.data.entities.Payment;
import com.diego.ecommerce.data.forms.PaymentForm;
import org.springframework.stereotype.Service;

@Service
public interface IPaymentService {

    Payment findById(Long id);

    Payment registerPayment(PaymentForm form);

}
