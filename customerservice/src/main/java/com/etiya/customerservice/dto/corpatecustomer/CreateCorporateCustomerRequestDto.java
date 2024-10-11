package com.etiya.customerservice.dto.corpatecustomer;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCorporateCustomerRequestDto {

    private Long taxNumber;
    private String contactName;
    private String companyName;
}
