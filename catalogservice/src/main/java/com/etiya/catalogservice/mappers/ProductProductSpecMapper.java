package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.productProductSpec.*;
import com.etiya.catalogservice.entities.ProductProductSpec;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductProductSpecMapper {

    ProductProductSpecMapper INSTANCE = Mappers.getMapper(ProductProductSpecMapper.class);

    CreatedProductProductSpecResponseDto createProductProductSpecResponseDtoFromProductProductSpec(ProductProductSpec productProductSpec);
    GetProductProductSpecResponseDto getProductProductSpecResponseDtoFromProductProductSpec(ProductProductSpec productProductSpec);
    List<ListProductProductSpecResponseDto> listProductProductSpecResponseDtoFromProductProductSpec(List<ProductProductSpec> dto);
    ProductProductSpec productProductSpecFromCreateProductProductSpecRequestDto(CreateProductProductSpecRequestDto dto);
    ProductProductSpec productProductSpecFromUpdateProductProductSpecRequestDto(UpdateProductProductSpecRequestDto dto);
    UpdatedProductProductSpecResponseDto updateProductProductSpecResponseDtoFromProductProductSpec(ProductProductSpec dto);


}
