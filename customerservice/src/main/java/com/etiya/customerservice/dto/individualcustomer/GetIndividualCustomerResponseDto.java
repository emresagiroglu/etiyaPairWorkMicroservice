package com.etiya.customerservice.dto.individualcustomer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private Date birthDate;
    private Character gender;
    private String fatherName;
    private String motherName;
    private String nationalityId;
}
