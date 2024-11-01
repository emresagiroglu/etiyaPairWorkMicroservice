package com.etiya.customerservice.dto.individualcustomer;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetIndividualCustomerResponseDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nationalityId;
}
