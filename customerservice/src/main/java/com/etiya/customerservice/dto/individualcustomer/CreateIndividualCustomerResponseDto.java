package com.etiya.customerservice.dto.individualcustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerResponseDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
}
