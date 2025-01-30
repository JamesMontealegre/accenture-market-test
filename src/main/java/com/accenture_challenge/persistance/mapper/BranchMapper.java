package com.accenture_challenge.persistance.mapper;

import com.accenture_challenge.domain.dto.BranchDTO;
import com.accenture_challenge.persistance.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    @Mapping(source = "franchise.id", target = "franchiseId")
    @Mapping(source = "franchise.name", target = "franchiseName")
    BranchDTO toDTO(Branch branch);

    @Mapping(target = "franchise", ignore = true)
    @Mapping(target = "products", ignore = true)
    Branch toEntity(BranchDTO branchDTO);

    List<BranchDTO> toDTOList(List<Branch> branches);
}
