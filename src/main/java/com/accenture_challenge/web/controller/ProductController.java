package com.accenture_challenge.web.controller;

import com.accenture_challenge.domain.dto.ProductDTO;
import com.accenture_challenge.domain.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProductToBranch(@RequestBody ProductDTO productDTO) {
        productRepository.addProductToBranch(productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long productId) {
        productRepository.removeProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productId}/stock/{newStock}")
    public ResponseEntity<Void> updateProductStock(@PathVariable Long productId, @PathVariable int newStock) {
        productRepository.updateProductStock(productId, newStock);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top-stocked/franchise/{franchiseId}")
    public ResponseEntity<List<ProductDTO>> getTopStockedProductsByFranchise(@PathVariable Long franchiseId) {
        return ResponseEntity.ok(productRepository.getTopStockedProductsByFranchise(franchiseId));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        Optional<ProductDTO> productDTO = productRepository.findById(productId);
        return productDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<ProductDTO>> getProductsByBranch(@PathVariable Long branchId) {
        List<ProductDTO> products = productRepository.getProductsByBranch(branchId);
        return ResponseEntity.ok(products);
    }
}
