package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.dtos.specification.*;
import com.etiya.catalogservice.entities.Specification;

import java.util.List;
import java.util.UUID;

public interface SpecificationService {

    CreatedSpecificationResponseDto add(CreateSpecificationRequestDto createSpecificationRequestDto);

    GetSpecificationResponseDto getById(UUID id);

    List<ListSpecificationResponseDto> getAll();

    UpdatedSpecificationResponseDto update(UUID id, UpdateSpecificationRequestDto updateSpecificationRequestDto);

    void delete(UUID id);

    Specification findById(UUID id);
}
