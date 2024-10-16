package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.category.*;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CreatedCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto);

    GetCategoryResponseDto getById(UUID id);

    List<ListCategoryResponseDto> getAll();

    UpdatedCategoryResponseDto update(UUID id, UpdateCategoryRequestDto updateCategoryRequestDto);

    void delete(UUID id);
}
