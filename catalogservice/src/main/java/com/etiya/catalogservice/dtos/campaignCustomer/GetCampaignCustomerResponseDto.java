package com.etiya.catalogservice.dtos.campaignCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCampaignCustomerResponseDto {
    private UUID campaignId;

    private UUID customerId;

    private UUID addressId;
}
