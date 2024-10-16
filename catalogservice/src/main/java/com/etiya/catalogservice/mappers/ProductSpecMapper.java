package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.productSpec.*;
import com.etiya.catalogservice.entities.ProductSpec;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductSpecMapper {

    ProductSpecMapper INSTANCE = Mappers.getMapper(ProductSpecMapper.class);

    CreatedProductSpecResponseDto createProductSpecResponseDtoFromProductSpec(ProductSpec productSpec);
    GetProductSpecResponseDto getProductSpecResponseDtoFromProductSpec(ProductSpec productSpec);
    List<ListProductSpecResponseDto> listProductSpecResponseDtoFromProductSpec(List<ProductSpec> dto);
    ProductSpec productSpecFromCreateProductSpecRequestDto(CreateProductSpecRequestDto dto);
    ProductSpec productSpecFromUpdateProductSpecRequestDto(UpdateProductSpecRequestDto dto);
    UpdatedProductSpecResponseDto updateProductSpecResponseDtoFromProductSpec(ProductSpec dto);

}
