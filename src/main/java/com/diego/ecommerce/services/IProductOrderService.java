package com.diego.ecommerce.services;

import com.diego.ecommerce.data.entities.ProductOrder;
import com.diego.ecommerce.data.forms.ProductOrderForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductOrderService {

    /**
    * Método responsável por retornar uma order a partir do ID
     */
    ProductOrder findById(Long id);

    /**
     * Método responsável por registar uama ordem
     * @param form Formulário contendo dados da ordem
     * @return
     */
    ProductOrder registerOrder(ProductOrderForm form);

    /**
     * Método responsável por retornar a lista de ordens de um cliente
     * @param id Id do cliente
     * @return
     */
    List<ProductOrder> findByClient(Long id);

    /**
     * Método responsável por cancelar uma ordem
     * @param id Id da ordem
     */
    void cancelOrder(Long id);
}
