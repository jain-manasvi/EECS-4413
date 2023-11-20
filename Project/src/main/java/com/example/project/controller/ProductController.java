package com.example.project.controller;

import com.example.project.repository.model.entity.Product;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {

        this.productService = productService;

    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> products = productService.findAllProducts();

        return ResponseEntity.ok(products);
    }





}
