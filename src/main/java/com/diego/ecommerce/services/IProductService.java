package com.diego.ecommerce.services;


import com.diego.ecommerce.data.entities.Product;
import com.diego.ecommerce.data.forms.ProductForm;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product registerProduct(ProductForm form);

    Product updateProduct(ProductForm form, Long id);

    void deleteProduct(Long id);

}
