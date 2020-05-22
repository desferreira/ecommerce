package com.diego.ecommerce.controllers;

import com.diego.ecommerce.data.entities.Product;
import com.diego.ecommerce.data.forms.ProductForm;
import com.diego.ecommerce.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    @Qualifier(value = "productServiceImpl")
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok().body(this.productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductForm form){
        return ResponseEntity.ok().body(this.productService.registerProduct(form));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductForm form, @PathVariable Long id){
        return ResponseEntity.ok().body(this.productService.updateProduct(form, id));
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().body("OK");
    }


}
