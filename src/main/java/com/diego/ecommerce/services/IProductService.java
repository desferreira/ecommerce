package com.diego.ecommerce.services;


import com.diego.ecommerce.data.entities.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product registerProduct(Long id);

    Product updateProduct(Long id);
}
