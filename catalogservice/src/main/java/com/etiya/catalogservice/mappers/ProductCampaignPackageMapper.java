package com.etiya.catalogservice.mappers;

import com.etiya.catalogservice.dtos.productCampaignPackage.*;

import com.etiya.catalogservice.entities.ProductCampaignPackage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductCampaignPackageMapper {

    ProductCampaignPackageMapper INSTANCE = Mappers.getMapper(ProductCampaignPackageMapper.class);

    @Mapping(target = "campaignId",source = "campaign.id")
    @Mapping(target = "productId",source = "product.id")
    CreatedProductCampaignPackageResponseDto createProductCampaignPackageResponseDtoFromProductCampaignPackage(ProductCampaignPackage productCampaignPackage);

    @Mapping(target = "campaignId",source = "campaign.id")
    @Mapping(target = "productId",source = "product.id")
    GetProductCampaignPackageResponseDto getProductCampaignPackageResponseDtoFromProductCampaignPackage(ProductCampaignPackage productCampaignPackage);

    @Mapping(target = "campaignId",source = "campaign.id")
    @Mapping(target = "productId",source = "product.id")
    default List<ListProductCampaignPackageResponseDto> listProductCampaignPackageResponseDtoFromProductCampaignPackage(List<ProductCampaignPackage> dtos){
        List<ListProductCampaignPackageResponseDto> responseDtos = dtos.stream().map(productCampaignPackage ->
                new ListProductCampaignPackageResponseDto(productCampaignPackage.getId(),productCampaignPackage.getProduct().getId(),
                        productCampaignPackage.getCampaign().getId())).toList();
        return responseDtos;
    }

    @Mapping(target = "campaign.id",source = "campaignId")
    @Mapping(target = "product.id",source = "productId")
    ProductCampaignPackage productCampaignPackageFromCreateProductCampaignPackageRequestDto(CreateProductCampaignPackageRequestDto dto);

    @Mapping(target = "campaign.id",source = "campaignId")
    @Mapping(target = "product.id",source = "productId")
    ProductCampaignPackage productCampaignPackageFromUpdateProductCampaignPackageRequestDto(UpdateProductCampaignPackageRequestDto dto);

    @Mapping(target = "campaignId",source = "campaign.id")
    @Mapping(target = "productId",source = "product.id")
    UpdatedProductCampaignPackageResponseDto updateProductCampaignPackageResponseDtoFromProductCampaignPackage(ProductCampaignPackage dto);
}
