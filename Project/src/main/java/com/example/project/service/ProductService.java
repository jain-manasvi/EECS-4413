package com.example.project.service;

import com.example.project.repository.model.entity.Product;
import com.example.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // Additional business logic methods can be added here
    public void addProducts(){
        productRepository.save(new Product("Tesla Model 3", "Tesla Model 3", 53990, "Tesla", "3", 2020, 438, 100));
        productRepository.save(new Product("Tesla Model Y", "Tesla Model Y", 57990, "Tesla", "Y", 2020, 534, 100));
//        productRepository.save(new Product("Porsche Panamera 4", "Porsche Panamera 4", 146200, "Porshe", "Panamera", 2022, 800, 100));
//        productRepository.save(new Product("GMC Hummer EV 3X", "GMC Hummer EV 3X", 119398, "GMC", "Hummer EV3X", 2020, 700, 100));
//        productRepository.save(new Product("Subaru Solterra Sport ", "Subaru Solterra Sport", 119398, "Subaru", "Solterra Sport",2023, 300, 100 ));
//        productRepository.save(new Product("Toyota Grand Highlander", "Toyota Grand Highlander", 65450, "Toyota", "Grand Highlander", 2024, 923, 100));
//        productRepository.save(new Product("Audi A5 Progressiv", "Audi A5 Progressiv", 58665, "Audi", "Progressiv", 2024, 784, 100));
    }

    @Override
    public void run(String... args) throws Exception {

        addProducts();
    }
}
