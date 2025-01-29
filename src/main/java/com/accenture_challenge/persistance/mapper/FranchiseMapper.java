package com.accenture_challenge.persistance.mapper;

import com.accenture_challenge.domain.dto.FranchiseDTO;
import com.accenture_challenge.persistance.entity.Franchise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
    })
    FranchiseDTO toDTO(Franchise franchise);

    @Mapping(target = "branches", ignore = true)
    Franchise toEntity(FranchiseDTO franchiseDTO);

    List<FranchiseDTO> toDTOList(List<Franchise> franchises);
}
