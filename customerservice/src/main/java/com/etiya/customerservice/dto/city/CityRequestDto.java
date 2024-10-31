package com.etiya.customerservice.dto.city;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityRequestDto {
    @NotEmpty
    private String name;
}
