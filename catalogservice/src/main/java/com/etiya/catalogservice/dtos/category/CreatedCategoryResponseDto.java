package com.etiya.catalogservice.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedCategoryResponseDto {
    private UUID id;
    private String name;
}
