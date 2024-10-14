package com.etiya.customerservice.dto.neighbourhood;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateNeighbourhoodRequestDto {
    @NotEmpty
    private String name;
    @NotNull
    private Long districtId;
}
