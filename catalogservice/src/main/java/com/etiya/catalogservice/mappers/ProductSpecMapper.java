package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.productSpec.*;
import com.etiya.catalogservice.entities.ProductSpec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductSpecMapper {

    ProductSpecMapper INSTANCE = Mappers.getMapper(ProductSpecMapper.class);

    @Mapping(target = "specificationId",source = "specification.id")
    @Mapping(target = "productId",source = "product.id")
    CreatedProductSpecResponseDto createProductSpecResponseDtoFromProductSpec(ProductSpec productSpec);

    @Mapping(target = "specificationId",source = "specification.id")
    @Mapping(target = "productId",source = "product.id")
    GetProductSpecResponseDto getProductSpecResponseDtoFromProductSpec(ProductSpec productSpec);

    @Mapping(target = "specificationId",source = "specification.id")
    @Mapping(target = "productId",source = "product.id")
    default List<ListProductSpecResponseDto> listProductSpecResponseDtoFromProductSpec(List<ProductSpec> dtos){
        List<ListProductSpecResponseDto> responseDtos = dtos.stream().map(productSpec ->
                new ListProductSpecResponseDto(productSpec.getId(),productSpec.getValue(), productSpec.getIsActive(), productSpec.getSpecification().getId(), productSpec.getProduct().getId())).toList();
        return responseDtos;
    }

    @Mapping(target = "specification.id",source = "specificationId")
    @Mapping(target = "product.id",source = "productId")
    ProductSpec productSpecFromCreateProductSpecRequestDto(CreateProductSpecRequestDto dto);

    @Mapping(target = "specification.id",source = "specificationId")
    @Mapping(target = "product.id",source = "productId")
    ProductSpec productSpecFromUpdateProductSpecRequestDto(UpdateProductSpecRequestDto dto);
    @Mapping(target = "specificationId",source = "specification.id")
    @Mapping(target = "productId",source = "product.id")
    UpdatedProductSpecResponseDto updateProductSpecResponseDtoFromProductSpec(ProductSpec dto);

}
