package com.etiya.catalogservice.dtos.offerProduct;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferProductRequestDto {
    @NotEmpty
    private String description;

    private int discountPercentage;

    private String discountDesc;

    private UUID offerId;

    private UUID productId;
}
