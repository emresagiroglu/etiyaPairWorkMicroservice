package com.etiya.catalogservice.dtos.productProductSpec;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedProductProductSpecResponseDto {
    private UUID id;

    private UUID productId;

    private UUID productSpecId;
}
