package com.etiya.customerservice.dto.disctrict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDistrictResponseDto {
    private UUID id;
    private String name;
    private Integer cityId;
}
