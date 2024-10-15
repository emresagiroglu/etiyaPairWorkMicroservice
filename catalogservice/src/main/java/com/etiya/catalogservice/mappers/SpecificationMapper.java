package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.specification.*;
import com.etiya.catalogservice.entities.Specification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SpecificationMapper {

    SpecificationMapper INSTANCE = Mappers.getMapper(SpecificationMapper.class);

    CreatedSpecificationResponseDto createSpecificationResponseDtoFromSpecification(Specification specification);
    GetSpecificationResponseDto getSpecificationResponseDtoFromSpecification(Specification specification);
    List<ListSpecificationResponseDto> listSpecificationResponseDtoFromSpecification(List<Specification> dto);
    Specification specificationFromCreateSpecificationRequestDto(CreateSpecificationRequestDto dto);
    Specification specificationFromUpdateSpecificationRequestDto(UpdateSpecificationRequestDto dto);
    UpdatedSpecificationResponseDto updateSpecificationResponseDtoFromSpecification(Specification dto);
}
