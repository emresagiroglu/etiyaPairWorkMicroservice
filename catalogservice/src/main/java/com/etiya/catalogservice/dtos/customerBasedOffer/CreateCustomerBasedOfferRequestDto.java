package com.etiya.catalogservice.dtos.customerBasedOffer;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerBasedOfferRequestDto {
    @NotNull
    private UUID offerId;
    @NotNull
    private Long customerId;
}
