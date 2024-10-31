package com.etiya.catalogservice.dtos.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto {
    @NotEmpty
    private String name;
    @NotNull
    private UUID categoryId;
    @NotNull
    private Double price;
}
