package com.etiya.catalogservice.dtos.productSpec;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedProductSpecResponseDto {

    private String value;

    private Boolean isActive;

    private UUID specificationId;

    private UUID productId;
}
