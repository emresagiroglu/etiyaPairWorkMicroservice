package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.productCampaignPackage.*;
import com.etiya.catalogservice.entities.ProductCampaignPackage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductCampaignPackageMapper {

    ProductCampaignPackageMapper INSTANCE = Mappers.getMapper(ProductCampaignPackageMapper.class);

    CreatedProductCampaignPackageResponseDto createProductCampaignPackageResponseDtoFromProductCampaignPackage(ProductCampaignPackage productCampaignPackage);
    GetProductCampaignPackageResponseDto getProductCampaignPackageResponseDtoFromProductCampaignPackage(ProductCampaignPackage productCampaignPackage);
    List<ListProductCampaignPackageResponseDto> listProductCampaignPackageResponseDtoFromProductCampaignPackage(List<ProductCampaignPackage> dto);
    ProductCampaignPackage productCampaignPackageFromCreateProductCampaignPackageRequestDto(CreateProductCampaignPackageRequestDto dto);
    ProductCampaignPackage productCampaignPackageFromUpdateProductCampaignPackageRequestDto(UpdateProductCampaignPackageRequestDto dto);
    UpdatedProductCampaignPackageResponseDto updateProductCampaignPackageResponseDtoFromProductCampaignPackage(ProductCampaignPackage dto);
}
