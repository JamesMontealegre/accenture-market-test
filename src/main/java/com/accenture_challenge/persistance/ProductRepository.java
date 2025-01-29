package com.accenture_challenge.persistance;

import com.accenture_challenge.persistance.crud.ProductCrudRepository;
import com.accenture_challenge.persistance.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final ProductCrudRepository productCrudRepository;

    public ProductRepository(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getTopStockedProductsByFranchise(Long franchiseId) {
        return productCrudRepository.findTopStockedProductsByFranchise(franchiseId);
    }
}
