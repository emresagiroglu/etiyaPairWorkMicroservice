package com.etiya.catalogservice.dtos.offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOfferResponseDto {

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;


}
