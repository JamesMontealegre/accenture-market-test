package com.accenture_challenge.domain.repository;

import com.accenture_challenge.domain.dto.FranchiseDTO;

import java.util.List;
import java.util.Optional;

public interface FranchiseRepository {
    FranchiseDTO addFranchise(FranchiseDTO franchiseDTO);

    Optional<FranchiseDTO> findById(Long franchiseId);

    List<FranchiseDTO> getAllFranchises();
}
