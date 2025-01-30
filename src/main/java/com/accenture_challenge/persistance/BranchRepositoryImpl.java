package com.accenture_challenge.persistance;

import com.accenture_challenge.domain.dto.BranchDTO;
import com.accenture_challenge.domain.repository.BranchRepository;
import com.accenture_challenge.persistance.crud.BranchCrudRepository;
import com.accenture_challenge.persistance.crud.FranchiseCrudRepository;
import com.accenture_challenge.persistance.entity.Branch;
import com.accenture_challenge.persistance.entity.Franchise;
import com.accenture_challenge.persistance.mapper.BranchMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BranchRepositoryImpl implements BranchRepository {

    private final BranchCrudRepository branchCrudRepository;
    private final FranchiseCrudRepository franchiseCrudRepository;
    private final BranchMapper branchMapper;

    public BranchRepositoryImpl(BranchCrudRepository branchCrudRepository,
                                FranchiseCrudRepository franchiseCrudRepository,
                                BranchMapper branchMapper) {
        this.branchCrudRepository = branchCrudRepository;
        this.franchiseCrudRepository = franchiseCrudRepository;
        this.branchMapper = branchMapper;
    }

    @Override
    @Transactional
    public BranchDTO addBranchToFranchise(Long franchiseId, BranchDTO branchDTO) {
        Franchise franchise = franchiseCrudRepository.findById(franchiseId)
                .orElseThrow(() -> new IllegalArgumentException("Franchise not found"));

        Branch branch = branchMapper.toEntity(branchDTO);
        branch.setFranchise(franchise);

        branch = branchCrudRepository.save(branch);
        return branchMapper.toDTO(branch);
    }


    @Override
    public Optional<BranchDTO> findById(Long branchId) {
        return branchCrudRepository.findById(branchId).map(branchMapper::toDTO);
    }

    @Override
    public List<BranchDTO> getBranchesByFranchise(Long franchiseId) {
        return branchMapper.toDTOList(branchCrudRepository.findByFranchiseId(franchiseId));
    }
}
