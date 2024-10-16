package com.etiya.catalogservice.dtos.offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOfferRequestDto {

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
