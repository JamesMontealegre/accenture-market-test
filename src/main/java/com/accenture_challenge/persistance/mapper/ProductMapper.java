package com.accenture_challenge.persistance.mapper;

import com.accenture_challenge.domain.dto.ProductDTO;
import com.accenture_challenge.persistance.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({@Mapping(source = "branch.id", target = "branchId"), @Mapping(source = "branch.name", target = "branchName")})
    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOList(List<Product> products);
}
