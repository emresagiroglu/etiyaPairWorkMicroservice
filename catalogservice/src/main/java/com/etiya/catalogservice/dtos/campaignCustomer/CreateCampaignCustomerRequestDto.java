package com.etiya.catalogservice.dtos.campaignCustomer;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignCustomerRequestDto {
    @NotNull
    private UUID campaignId;
    @NotNull
    private Long customerId;
    @NotNull
    private Long addressId;
}
