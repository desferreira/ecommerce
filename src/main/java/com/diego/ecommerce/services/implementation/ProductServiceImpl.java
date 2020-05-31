package com.diego.ecommerce.services.implementation;

import com.diego.ecommerce.data.entities.Product;
import com.diego.ecommerce.data.entities.enums.CategoryType;
import com.diego.ecommerce.data.forms.ProductForm;
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
    public Product registerProduct(ProductForm form) {

        Product product = this.createProductFromForm(form);

        logger.log(Level.INFO, String.format("Saving the product [%s]", product.name));

        this.repository.save(product);

        return product;
    }

    @Override
    public Product updateProduct(ProductForm form, Long id) {
        Optional<Product> productOptional = this.repository.findById(id);

        if (productOptional.isEmpty()){
            logger.log(Level.SEVERE, String.format("Product with id [%d] is not found", id));
            throw new HttpException(String.format("Product with id [%d] is not found", id),
                    HttpStatus.NOT_FOUND, "Not found");
        }

        Product oldProduct = productOptional.get();
        Product newProduct = this.createProductFromForm(form);
        Product updatedProduct = this.updateProductData(oldProduct, newProduct);

        this.repository.save(updatedProduct);
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        this.repository.deleteById(id);
    }

    private Product createProductFromForm(ProductForm form) {

        if (form == null){
            logger.log(Level.SEVERE, String.format("The form is null!"));
            throw new HttpException("This form is invalid!", HttpStatus.BAD_REQUEST, "Erro");
        }

        Product product = new Product();
        product.name = form.name;
        product.description = form.description;
        product.productImage = form.productImage;
        product.price = form.price;
        product.categoryType = CategoryType.valueOf(form.category);
        product.productQuantity = form.quantity;

        return product;
    }

    private Product updateProductData(Product oldObj, Product newObj){
        oldObj.name = newObj.name;
        oldObj.description = newObj.description;
        oldObj.productImage = newObj.productImage;
        oldObj.price = newObj.price;
        oldObj.categoryType = newObj.categoryType;
        oldObj.productQuantity = newObj.productQuantity;
        return oldObj;
    }
}
