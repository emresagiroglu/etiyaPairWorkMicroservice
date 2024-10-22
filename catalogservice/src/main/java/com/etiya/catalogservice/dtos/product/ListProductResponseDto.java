package com.etiya.catalogservice.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListProductResponseDto {

    private UUID id;

    private String name;

    private UUID categoryId;
    private Double price;
}
