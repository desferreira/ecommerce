package com.diego.ecommerce.controllers;

import com.diego.ecommerce.data.entities.Payment;
import com.diego.ecommerce.data.forms.PaymentForm;
import com.diego.ecommerce.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    @Qualifier(value = "paymentServiceImpl")
    private IPaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment payment =  this.paymentService.findById(id);
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping
    public ResponseEntity<Payment> registerPayment(@RequestBody PaymentForm form){
        return ResponseEntity.ok().body(this.paymentService.registerPayment(form));
    }

}
