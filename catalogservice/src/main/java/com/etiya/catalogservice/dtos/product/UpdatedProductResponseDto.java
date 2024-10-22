package com.etiya.catalogservice.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedProductResponseDto {

    private String name;

    private UUID categoryId;
    private Double price;

}
