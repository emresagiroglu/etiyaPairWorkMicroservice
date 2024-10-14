package com.etiya.catalogservice.dtos.productSpec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductSpecResponseDto {

    private String value;

    private UUID specificationId;
}
