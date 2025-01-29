package com.accenture_challenge.persistance;

import com.accenture_challenge.domain.dto.FranchiseDTO;
import com.accenture_challenge.domain.repository.FranchiseRepository;
import com.accenture_challenge.persistance.crud.FranchiseCrudRepository;
import com.accenture_challenge.persistance.entity.Franchise;
import com.accenture_challenge.persistance.mapper.FranchiseMapper;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class FranchiseRepositoryImpl implements FranchiseRepository {
    private final FranchiseCrudRepository franchiseCrudRepository;
    private final FranchiseMapper franchiseMapper;

    public FranchiseRepositoryImpl(FranchiseCrudRepository franchiseCrudRepository, FranchiseMapper franchiseMapper) {
        this.franchiseCrudRepository = franchiseCrudRepository;
        this.franchiseMapper = franchiseMapper;
    }

    @Override
    @Transactional
    public FranchiseDTO addFranchise(FranchiseDTO franchiseDTO) {
        if (franchiseCrudRepository.existsByName(franchiseDTO.getName())) {
            throw new IllegalArgumentException("Franchise with this name already exists");
        }

        Franchise franchise = franchiseMapper.toEntity(franchiseDTO);
        franchise = franchiseCrudRepository.save(franchise);
        return franchiseMapper.toDTO(franchise);
    }

    @Override
    public Optional<FranchiseDTO> findById(Long franchiseId) {
        return franchiseCrudRepository.findById(franchiseId).map(franchiseMapper::toDTO);
    }

    @Override
    public List<FranchiseDTO> getAllFranchises() {
        return franchiseMapper.toDTOList((List<Franchise>) franchiseCrudRepository.findAll());
    }
}
