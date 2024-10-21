package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.productSpec.*;
import com.etiya.catalogservice.entities.ProductSpec;

import java.util.List;
import java.util.UUID;

public interface ProductSpecService {

    CreatedProductSpecResponseDto add(CreateProductSpecRequestDto createProductSpecRequestDto);

    GetProductSpecResponseDto getById(UUID id);

    List<ListProductSpecResponseDto> getAll();

    UpdatedProductSpecResponseDto update(UUID id, UpdateProductSpecRequestDto updateProductSpecRequestDto);

    void delete(UUID id);

    ProductSpec findById(UUID id);

}
