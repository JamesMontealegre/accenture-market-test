package com.accenture_challenge.domain.repository;

import com.accenture_challenge.domain.dto.BranchDTO;

import java.util.List;
import java.util.Optional;

public interface BranchRepository {
    BranchDTO addBranchToFranchise(Long franchiseId, BranchDTO branchDTO);
    Optional<BranchDTO> findById(Long branchId);
    List<BranchDTO> getBranchesByFranchise(Long franchiseId);
}
