package com.etiya.customerservice.dto.disctrict;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateDistrictRequestDto {
        @NotNull
        @NotBlank
        private String name;
        @NotNull
        @NotBlank
        private Long cityId;
}
