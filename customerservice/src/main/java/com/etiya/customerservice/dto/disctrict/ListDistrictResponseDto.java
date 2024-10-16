package com.etiya.customerservice.dto.disctrict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListDistrictResponseDto {
    private Long id;
    private String name;
    private Long cityId;
}
