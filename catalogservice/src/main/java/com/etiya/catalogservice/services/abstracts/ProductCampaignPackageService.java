package com.etiya.catalogservice.services.abstracts;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.dtos.productCampaignPackage.*;

import java.util.List;
import java.util.UUID;

public interface ProductCampaignPackageService {

    CreatedProductCampaignPackageResponseDto add(CreateProductCampaignPackageRequestDto createProductCampaignPackageRequestDto);

    GetProductCampaignPackageResponseDto getById(UUID id);

    List<ListProductCampaignPackageResponseDto> getAll();

    UpdatedProductCampaignPackageResponseDto update(UUID id, UpdateProductCampaignPackageRequestDto updateProductCampaignPackageRequestDto);

    void delete(UUID id);

}
