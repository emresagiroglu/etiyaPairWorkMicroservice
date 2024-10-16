package com.etiya.catalogservice.dtos.productCampaignPackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedProductCampaignPackageResponseDto {

    private UUID productId;

    private UUID campaignId;
}
