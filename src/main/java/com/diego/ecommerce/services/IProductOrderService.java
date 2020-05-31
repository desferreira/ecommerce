package com.diego.ecommerce.services;

import com.diego.ecommerce.data.entities.ProductOrder;
import com.diego.ecommerce.data.forms.ProductOrderForm;
import org.springframework.stereotype.Service;

@Service
public interface IProductOrderService {

    ProductOrder findById(Long id);

    ProductOrder registerOrder(ProductOrderForm form);

    void cancelOrder(Long id);
}
