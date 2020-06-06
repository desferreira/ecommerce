package com.diego.ecommerce.services;


import com.diego.ecommerce.data.entities.Product;
import com.diego.ecommerce.data.forms.ProductForm;

import java.util.List;

public interface IProductService {

    /**
     * Método responsável por buuscar todos os produtos
     * @return
     */
    List<Product> findAll();

    /**
     * Método responsável por buscar um produto por ID
     * @param id ID do produto
     * @return
     */
    Product findById(Long id);

    /**
     * Método responsável por registar um produto
     * @param form Formulário contendo os dados do produto
     * @return
     */
    Product registerProduct(ProductForm form);

    /**
     * Método responsável por realizar um upadate no produto
     * @param form Novos dados do produto
     * @param id Id do produto a ser editaod
     * @return
     */
    Product updateProduct(ProductForm form, Long id);

    /**
     * Método responsável por apagar um produto
     * @param id
     */
    void deleteProduct(Long id);

}
