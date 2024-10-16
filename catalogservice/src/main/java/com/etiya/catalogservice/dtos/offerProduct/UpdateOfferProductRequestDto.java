package com.etiya.catalogservice.dtos.offerProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOfferProductRequestDto {

    private String description;

    private int discountPercentage;

    private String discountDesc;

    private UUID offerId;

    private UUID productId;

}
