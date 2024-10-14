package com.etiya.customerservice.dto.individualcustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerResponseDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String fatherName;
    private String motherName;
    private Boolean nationality;
    private Long nationalityId;
}
