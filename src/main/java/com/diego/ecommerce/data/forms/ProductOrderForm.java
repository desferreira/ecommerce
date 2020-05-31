package com.diego.ecommerce.data.forms;

import com.diego.ecommerce.data.entities.Product;

import java.util.List;

public class ProductOrderForm {

    /**
     * Lista com id dos produtos
     */
    public List<Long> products;

    public PaymentForm paymentForm;

}
