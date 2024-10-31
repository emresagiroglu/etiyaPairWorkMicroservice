package com.etiya.catalogservice.dtos.specification;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSpecificationRequestDto {
    @NotEmpty
    private String name;

    private String dataType;

}
