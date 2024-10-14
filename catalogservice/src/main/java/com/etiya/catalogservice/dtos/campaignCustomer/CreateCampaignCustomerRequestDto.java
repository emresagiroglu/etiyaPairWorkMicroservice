package com.etiya.catalogservice.dtos.campaignCustomer;

import com.etiya.catalogservice.entities.Campaign;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignCustomerRequestDto {

    private UUID campaignId;

    private UUID customerId;

    private UUID addressId;
}
