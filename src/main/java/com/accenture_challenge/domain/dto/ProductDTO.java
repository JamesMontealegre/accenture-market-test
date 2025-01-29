package com.accenture_challenge.domain.dto;

public class ProductDTO {
    private Long id;
    private String name;
    private int stock;
    private Long branchId;
    private String branchName;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, int stock, Long branchId, String branchName) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}

