package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.product.*;
import com.etiya.catalogservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "categoryId",source = "category.id")
    CreatedProductResponseDto createProductResponseDtoFromProduct(Product product);

    @Mapping(target = "categoryId",source = "category.id")
    GetProductResponseDto getProductResponseDtoFromProduct(Product product);

    @Mapping(target = "categoryId",source = "category.id")
    default List<ListProductResponseDto> listProductResponseDtoFromProduct(List<Product> dtos){
        List<ListProductResponseDto> responseDtos = dtos.stream().map(product ->
                new ListProductResponseDto(product.getId(),product.getName(), product.getCategory().getId(), product.getPrice())).toList();
        return responseDtos;
    }

    @Mapping(target = "category.id",source = "categoryId")
    Product productFromCreateProductRequestDto(CreateProductRequestDto dto);

    @Mapping(target = "category.id",source = "categoryId")
    Product productFromUpdateProductRequestDto(UpdateProductRequestDto dto);

    @Mapping(target = "categoryId",source = "category.id")
    UpdatedProductResponseDto updateProductResponseDtoFromProduct(Product dto);
}
