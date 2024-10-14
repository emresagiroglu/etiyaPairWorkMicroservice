package com.etiya.catalogservice.dtos.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSpecificationResponseDto {

    private String name;

    private String dataType;

}
