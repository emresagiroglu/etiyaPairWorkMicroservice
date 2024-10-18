package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.product.*;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    CreatedProductResponseDto add(CreateProductRequestDto createProductRequestDto);

    GetProductResponseDto getById(UUID id);

    List<ListProductResponseDto> getAll();

    UpdatedProductResponseDto update(UUID id, UpdateProductRequestDto updateProductRequestDto);

    void delete(UUID id);

}
