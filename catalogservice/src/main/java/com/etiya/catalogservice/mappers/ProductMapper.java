package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.product.*;
import com.etiya.catalogservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    CreatedProductResponseDto createProductResponseDtoFromProduct(Product product);
    GetProductResponseDto getProductResponseDtoFromProduct(Product product);
    List<ListProductResponseDto> listProductResponseDtoFromProduct(List<Product> dto);
    Product productFromCreateProductRequestDto(CreateProductRequestDto dto);
    Product productFromUpdateProductRequestDto(UpdateProductRequestDto dto);
    UpdatedProductResponseDto updateProductResponseDtoFromProduct(Product dto);
}
