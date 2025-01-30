package com.accenture_challenge.persistance;

import com.accenture_challenge.domain.dto.FranchiseDTO;
import com.accenture_challenge.domain.repository.FranchiseRepository;
import com.accenture_challenge.persistance.crud.FranchiseCrudRepository;
import com.accenture_challenge.persistance.entity.Franchise;
import com.accenture_challenge.persistance.mapper.FranchiseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FranchiseRepositoryImpl implements FranchiseRepository {

    private final FranchiseCrudRepository franchiseCrudRepository;
    private final FranchiseMapper franchiseMapper;

    public FranchiseRepositoryImpl(FranchiseCrudRepository franchiseCrudRepository, FranchiseMapper franchiseMapper) {
        this.franchiseCrudRepository = franchiseCrudRepository;
        this.franchiseMapper = franchiseMapper;
    }

    @Override
    public FranchiseDTO addFranchise(FranchiseDTO franchiseDTO) {
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
