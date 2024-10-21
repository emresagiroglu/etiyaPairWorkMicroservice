package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.productProductSpec.*;
import com.etiya.catalogservice.entities.ProductCampaignPackage;
import com.etiya.catalogservice.entities.ProductProductSpec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductProductSpecMapper {

    ProductProductSpecMapper INSTANCE = Mappers.getMapper(ProductProductSpecMapper.class);

    @Mapping(target = "productId",source = "product.id")
    @Mapping(target = "productSpecId",source = "productSpec.id")
    CreatedProductProductSpecResponseDto createProductProductSpecResponseDtoFromProductProductSpec(ProductProductSpec productProductSpec);

    @Mapping(target = "productId",source = "product.id")
    @Mapping(target = "productSpecId",source = "productSpec.id")
    GetProductProductSpecResponseDto getProductProductSpecResponseDtoFromProductProductSpec(ProductProductSpec productProductSpec);

    @Mapping(target = "productId",source = "product.id")
    @Mapping(target = "productSpecId",source = "productSpec.id")
    //List<ListProductProductSpecResponseDto> listProductProductSpecResponseDtoFromProductProductSpec(List<ProductProductSpec> dto);
    default List<ListProductProductSpecResponseDto> listProductProductSpecResponseDtoFromProductProductSpec(List<ProductProductSpec> dtos){
        List<ListProductProductSpecResponseDto> responseDtos = dtos.stream().map(productProductSpec ->
                new ListProductProductSpecResponseDto(
                        productProductSpec.getId(),
                        productProductSpec.getProduct().getId(),
                        productProductSpec.getProductSpec().getId())).toList();
        return responseDtos;
    }

    @Mapping(target = "product.id",source = "productId")
    @Mapping(target = "productSpec.id",source = "productSpecId")
    ProductProductSpec productProductSpecFromCreateProductProductSpecRequestDto(CreateProductProductSpecRequestDto dto);

    @Mapping(target = "product.id",source = "productId")
    @Mapping(target = "productSpec.id",source = "productSpecId")
    ProductProductSpec productProductSpecFromUpdateProductProductSpecRequestDto(UpdateProductProductSpecRequestDto dto);

    @Mapping(target = "productId",source = "product.id")
    @Mapping(target = "productSpecId",source = "productSpec.id")
    UpdatedProductProductSpecResponseDto updateProductProductSpecResponseDtoFromProductProductSpec(ProductProductSpec dto);


}
