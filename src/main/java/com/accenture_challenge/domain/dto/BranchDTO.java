package com.accenture_challenge.domain.dto;

public class BranchDTO {
    private final Long id;
    private final String name;
    private final Long franchiseId;
    private final String franchiseName;

    public BranchDTO(Long id, String name, Long franchiseId, String franchiseName) {
        this.id = id;
        this.name = name;
        this.franchiseId = franchiseId;
        this.franchiseName = franchiseName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }

    public String getFranchiseName() {
        return franchiseName;
    }
}

