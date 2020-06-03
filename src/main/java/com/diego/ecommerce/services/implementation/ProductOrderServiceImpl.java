package com.diego.ecommerce.services.implementation;

import com.diego.ecommerce.data.entities.Payment;
import com.diego.ecommerce.data.entities.Product;
import com.diego.ecommerce.data.entities.ProductOrder;
import com.diego.ecommerce.data.entities.enums.ProductOrderStatus;
import com.diego.ecommerce.data.forms.ProductOrderForm;
import com.diego.ecommerce.exception.HttpException;
import com.diego.ecommerce.repositories.IProductOrderRepository;
import com.diego.ecommerce.services.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductOrderServiceImpl implements IProductOrderService {

    Logger logger = Logger.getLogger("productOrderServiceImpl");

    @Autowired
    private IProductOrderRepository repository;

    @Autowired
    private PaymentServiceImpl paymentService;

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public ProductOrder findById(Long id) {
        logger.log(Level.INFO, String.format("Finding the ProductOrder with id [%d]", id));
        Optional<ProductOrder> productOrderOptional = this.repository.findById(id);

        if (productOrderOptional.isEmpty()){
            logger.log(Level.SEVERE, String.format("ProductOrder with id [%d] is not found", id));
            throw new HttpException(String.format("ProductOrder with id [%d] is not found", id),
                    HttpStatus.NOT_FOUND, "Not found");
        }
        return productOrderOptional.get();
        }

    @Override
    public ProductOrder registerOrder(ProductOrderForm form) {

        if (form == null){
            logger.log(Level.SEVERE, String.format("The form is null!"));
            throw new HttpException("This form is invalid!", HttpStatus.BAD_REQUEST, "Erro");
        }

        ProductOrder productOrder = new ProductOrder();
        Payment payment = this.paymentService.registerPayment(form.paymentForm);

        productOrder.productList = this.createProductList(form.products);
        productOrder.payment = payment;

        this.repository.save(productOrder);

        return productOrder;
    }

    @Override
    public List<ProductOrder> findByClient(Long id) {
        logger.log(Level.INFO, String.format("Searching for orders from client [%d]", id));
        List<ProductOrder> orders = this.repository.findByClient_Id(id);

        return orders;
    }

    @Override
    public void cancelOrder(Long id) {
        ProductOrder productOrder = this.repository.getOne(id);

        productOrder.status = ProductOrderStatus.CANCELED;

        this.repository.save(productOrder);
    }



    private List<Product> createProductList(List<Long> productId){
        List<Product> productList = new ArrayList<>();
        for (Long id : productId) {
            Product product = this.productService.findById(id);
            productList.add(product);
        }
        return productList;
    }
}
