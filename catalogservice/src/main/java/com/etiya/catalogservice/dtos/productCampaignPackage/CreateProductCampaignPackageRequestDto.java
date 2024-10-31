package com.etiya.catalogservice.dtos.productCampaignPackage;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCampaignPackageRequestDto {
    @NotNull
    private UUID productId;
    @NotNull
    private UUID campaignId;

}
