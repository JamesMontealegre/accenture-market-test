package com.accenture_challenge.persistance;

import com.accenture_challenge.domain.dto.ProductDTO;
import com.accenture_challenge.domain.repository.ProductRepository;
import com.accenture_challenge.persistance.crud.BranchCrudRepository;
import com.accenture_challenge.persistance.crud.ProductCrudRepository;
import com.accenture_challenge.persistance.entity.Branch;
import com.accenture_challenge.persistance.entity.Product;
import com.accenture_challenge.persistance.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductCrudRepository productCrudRepository;
    private final BranchCrudRepository branchCrudRepository;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository,
                                 BranchCrudRepository branchCrudRepository,
                                 ProductMapper productMapper) {
        this.productCrudRepository = productCrudRepository;
        this.branchCrudRepository = branchCrudRepository;
        this.productMapper = productMapper;
    }

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void addProductToBranch(ProductDTO productDTO) {
        Branch branch = branchCrudRepository.findById(productDTO.getBranchId())
                .orElseThrow(() -> new IllegalArgumentException("Branch not found"));

        Product product = new Product(productDTO.getName(), productDTO.getStock(), branch);
        productCrudRepository.save(product);
    }

    @Override
    @Transactional
    public void removeProduct(Long productId) {
        if (!productCrudRepository.existsById(productId)) {
            throw new IllegalArgumentException("Product not found");
        }
        productCrudRepository.deleteById(productId);
    }

    @Override
    @Transactional
    public void updateProductStock(Long productId, int newStock) {
        Product product = productCrudRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setStock(newStock);
        productCrudRepository.save(product);
    }

    @Override
    public List<ProductDTO> getTopStockedProductsByFranchise(Long franchiseId) {
        return productMapper.toDTOList(productCrudRepository.findTopStockedProductsByFranchise(franchiseId));
    }

    @Override
    public Optional<ProductDTO> findById(Long productId) {
        return productCrudRepository.findById(productId)
                .map(productMapper::toDTO);
    }

    @Override
    public List<ProductDTO> getProductsByBranch(Long branchId) {
        List<Product> products = productCrudRepository.findByBranchId(branchId);
        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
    }
}
