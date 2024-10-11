package com.etiya.customerservice.dto.corporatecustomer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCorporateCustomerRequestDto {


    @NotBlank
    @NotNull
    private Long taxNumber;

    @NotBlank
    @NotNull
    private String contactName;

    @NotBlank
    @NotNull
    private String companyName;
}
