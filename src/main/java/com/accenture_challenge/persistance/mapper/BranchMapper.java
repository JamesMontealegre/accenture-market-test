package com.accenture_challenge.persistance.mapper;

import com.accenture_challenge.domain.dto.BranchDTO;
import com.accenture_challenge.persistance.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    @Mappings({
            @Mapping(source = "franchise.id", target = "franchiseId"),
            @Mapping(source = "franchise.name", target = "franchiseName")
    })
    BranchDTO toDTO(Branch branch);

    @Mappings({
            @Mapping(target = "franchise", ignore = true)
    })
    Branch toEntity(BranchDTO branchDTO);

    List<BranchDTO> toDTOList(List<Branch> branches);
}
