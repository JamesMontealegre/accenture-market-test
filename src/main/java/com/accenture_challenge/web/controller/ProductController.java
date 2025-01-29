package com.accenture_challenge.web.controller;

import com.accenture_challenge.persistance.ProductRepository;
import com.accenture_challenge.persistance.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/top-stock/{franchiseId}")
    public List<Product> getTopStockedProducts(@PathVariable Long franchiseId) {
        return productRepository.getTopStockedProductsByFranchise(franchiseId);
    }
}
