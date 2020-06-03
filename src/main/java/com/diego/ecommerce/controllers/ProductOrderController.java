package com.diego.ecommerce.controllers;

import com.diego.ecommerce.data.entities.ProductOrder;
import com.diego.ecommerce.data.forms.ProductOrderForm;
import com.diego.ecommerce.services.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class ProductOrderController {

    @Autowired
    @Qualifier("productOrderServiceImpl")
    private IProductOrderService productOrderService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductOrder> findById(@PathVariable Long id){
        ProductOrder productOrder = this.productOrderService.findById(id);
        return ResponseEntity.ok().body(productOrder);
    }

    @PostMapping
    public ResponseEntity<ProductOrder> findById(@RequestBody ProductOrderForm form){
        ProductOrder productOrder = this.productOrderService.registerOrder(form);
        return ResponseEntity.ok().body(productOrder);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ProductOrder>> findAllByClient(@PathVariable Long id){
        List<ProductOrder> orderList = this.productOrderService.findByClient(id);
        return ResponseEntity.ok().body(orderList);
    }

}
