package com.etiya.customerservice.dto.corporatecustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListCorporateCustomerResponseDto {



    private Long id;
    private Long taxNumber;
    private String contactName;
    private String companyName;
}
