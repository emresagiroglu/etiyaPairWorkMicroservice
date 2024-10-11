package com.etiya.customerservice.dto.individualcustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListIndividualCustomerResponseDto {

    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
}
