package com.etiya.catalogservice.dtos.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSpecificationResponseDto {

    private UUID id;

    private String name;

    private String dataType;
}
