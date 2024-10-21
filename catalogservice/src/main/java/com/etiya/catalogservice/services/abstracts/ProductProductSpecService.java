package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.dtos.productProductSpec.*;

import java.util.List;
import java.util.UUID;

public interface ProductProductSpecService {

    CreatedProductProductSpecResponseDto add(CreateProductProductSpecRequestDto createProductProductSpecRequestDto);

    GetProductProductSpecResponseDto getById(UUID id);

    List<ListProductProductSpecResponseDto> getAll();

    UpdatedProductProductSpecResponseDto update(UUID id, UpdateProductProductSpecRequestDto updateProductProductSpecRequestDto);

    void delete(UUID id);

}
