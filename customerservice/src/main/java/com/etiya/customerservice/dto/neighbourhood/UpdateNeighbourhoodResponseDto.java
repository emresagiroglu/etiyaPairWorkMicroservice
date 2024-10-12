package com.etiya.customerservice.dto.neighbourhood;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateNeighbourhoodResponseDto {
    private UUID id;
    private String name;
    private Integer districtId;
}
