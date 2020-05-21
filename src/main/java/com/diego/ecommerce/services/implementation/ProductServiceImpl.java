package com.diego.ecommerce.services.implementation;

import com.diego.ecommerce.data.entities.Product;
import com.diego.ecommerce.exception.HttpException;
import com.diego.ecommerce.repositories.IProductRepository;
import com.diego.ecommerce.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements IProductService {

    Logger logger = Logger.getLogger("productServiceImpl");

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = this.repository.findById(id);
        if (product.isEmpty()){
            logger.log(Level.SEVERE, String.format("Product with id [%d] is not found", id));
            throw new HttpException(String.format("Product with id [%d] is not found", id),
                    HttpStatus.NOT_FOUND, "Not found");
        }
        return product.get();
    }

    @Override
    public Product registerProduct(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }
}
