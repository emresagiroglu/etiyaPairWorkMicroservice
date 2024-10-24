package com.etiya.catalogservice.dtos.customerBasedOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedCustomerBasedOfferResponseDto {

    private UUID id;

    private UUID offerId;

    private Long customerId;
}
