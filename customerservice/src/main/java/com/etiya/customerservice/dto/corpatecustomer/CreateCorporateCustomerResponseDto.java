package com.etiya.customerservice.dto.corpatecustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCorporateCustomerResponseDto {


    private UUID id;
    private Long taxNumber;
    private String contactName;
    private String companyName;

}
