package com.accenture_challenge.domain.repository;

import com.accenture_challenge.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void addProductToBranch(ProductDTO productDTO);
    void removeProduct(Long productId);
    void updateProductStock(Long productId, int newStock);
    List<ProductDTO> getTopStockedProductsByFranchise(Long franchiseId);
    Optional<ProductDTO> findById(Long productId);
    List<ProductDTO> getProductsByBranch(Long branchId);
}
