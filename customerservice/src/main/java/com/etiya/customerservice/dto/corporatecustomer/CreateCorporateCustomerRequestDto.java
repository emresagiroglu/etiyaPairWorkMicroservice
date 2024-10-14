package com.etiya.customerservice.dto.corporatecustomer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCorporateCustomerRequestDto {


    @NotEmpty
    @Size(min = 9,max = 9)
    private String taxNumber;

    @NotEmpty
    private String contactName;

    @NotEmpty
    private String companyName;
}
