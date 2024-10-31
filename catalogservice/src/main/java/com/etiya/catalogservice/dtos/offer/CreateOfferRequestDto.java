package com.etiya.catalogservice.dtos.offer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfferRequestDto {
    @NotEmpty
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
