package com.etiya.catalogservice.dtos.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCampaignResponseDto {

    private String name;

    private int discountPercentage;

    private String discountDesc;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
