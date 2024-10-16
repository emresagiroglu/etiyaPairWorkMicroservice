package com.etiya.catalogservice.dtos.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedCampaignResponseDto {

    private UUID id;

    private String name;

    private int discountPercentage;

    private String discountDesc;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
