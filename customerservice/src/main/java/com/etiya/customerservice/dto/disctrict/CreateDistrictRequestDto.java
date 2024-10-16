package com.etiya.customerservice.dto.disctrict;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateDistrictRequestDto {
        @NotEmpty
        private String name;
        @NotNull
        private Long cityId;
}
