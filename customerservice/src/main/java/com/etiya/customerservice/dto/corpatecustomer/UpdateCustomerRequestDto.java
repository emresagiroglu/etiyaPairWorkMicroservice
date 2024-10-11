package com.etiya.customerservice.dto.corpatecustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequestDto {

    private Long taxNumber;
    private String contactName;
    private String companyName;
}
