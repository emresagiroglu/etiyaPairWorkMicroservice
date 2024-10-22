package com.etiya.catalogservice.dtos.product;

import com.etiya.catalogservice.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedProductResponseDto {

    private UUID id;

    private String name;

    private UUID categoryId;

    private Double price;

}
