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
    CreatedProductSpecResponseDto createProductSpecResponseDtoFromProductSpec(ProductSpec productSpec);

    @Mapping(target = "specificationId",source = "specification.id")
    GetProductSpecResponseDto getProductSpecResponseDtoFromProductSpec(ProductSpec productSpec);

//    @Mapping(target = "specificationId",source = "specification.id")
//    List<ListProductSpecResponseDto> listProductSpecResponseDtoFromProductSpec(List<ProductSpec> dto);

    @Mapping(target = "specificationId",source = "specification.id")
    default List<ListProductSpecResponseDto> listProductSpecResponseDtoFromProductSpec(List<ProductSpec> dtos){
        List<ListProductSpecResponseDto> responseDtos = dtos.stream().map(productSpec ->
                new ListProductSpecResponseDto(productSpec.getId(),productSpec.getValue(),productSpec.getSpecification().getId())).toList();
        return responseDtos;
    }

    @Mapping(target = "specification.id",source = "specificationId")
    ProductSpec productSpecFromCreateProductSpecRequestDto(CreateProductSpecRequestDto dto);

    @Mapping(target = "specification.id",source = "specificationId")
    ProductSpec productSpecFromUpdateProductSpecRequestDto(UpdateProductSpecRequestDto dto);
    @Mapping(target = "specificationId",source = "specification.id")
    UpdatedProductSpecResponseDto updateProductSpecResponseDtoFromProductSpec(ProductSpec dto);

}
