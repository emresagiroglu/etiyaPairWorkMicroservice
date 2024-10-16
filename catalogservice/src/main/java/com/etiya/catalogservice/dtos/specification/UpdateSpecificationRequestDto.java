package com.etiya.catalogservice.dtos.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSpecificationRequestDto {

    private String name;

    private String dataType;

}
