package com.diego.ecommerce.services;

import com.diego.ecommerce.data.entities.ProductOrder;
import com.diego.ecommerce.data.forms.ProductOrderForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductOrderService {

    ProductOrder findById(Long id);

    ProductOrder registerOrder(ProductOrderForm form);

    List<ProductOrder> findByClient(Long id);

    void cancelOrder(Long id);
}
