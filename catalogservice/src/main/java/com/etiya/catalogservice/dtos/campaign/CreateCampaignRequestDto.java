package com.etiya.catalogservice.dtos.campaign;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCampaignRequestDto {
    @NotEmpty
    private String name;
    private int discountPercentage;

    private String discountDesc;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
