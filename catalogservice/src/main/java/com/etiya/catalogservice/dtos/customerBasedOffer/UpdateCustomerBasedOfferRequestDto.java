package com.etiya.catalogservice.dtos.customerBasedOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerBasedOfferRequestDto {

    private UUID offerId;

    private Long customerId;
}
