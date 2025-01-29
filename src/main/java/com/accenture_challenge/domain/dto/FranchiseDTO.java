package com.accenture_challenge.domain.dto;

import java.util.List;

public class FranchiseDTO {
    private final Long id;
    private final String name;
    private final List<BranchDTO> branches;

    public FranchiseDTO(Long id, String name, List<BranchDTO> branches) {
        this.id = id;
        this.name = name;
        this.branches = branches;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<BranchDTO> getBranches() {
        return branches;
    }
}