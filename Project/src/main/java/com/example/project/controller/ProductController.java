package com.example.project.controller;

import com.example.project.repository.model.entity.Product;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getFullPriceProducts")
    public ResponseEntity<List<Product>> getFullPriceProducts(){

        List<Product> products = productService.findFullPriceProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/getDiscountedProducts")
    public ResponseEntity<List<Product>> getDiscountedProducts(){

        List<Product> products = productService.findDiscountedProducts();

        return ResponseEntity.ok(products);
    }

    @PostMapping("/getFilteredProducts")
    public ResponseEntity<List<Product>> getFilteredProducts(@RequestBody String brand){

        List<Product> products = productService.findFilteredProducts(brand);

        return ResponseEntity.ok(products);
    }

}
