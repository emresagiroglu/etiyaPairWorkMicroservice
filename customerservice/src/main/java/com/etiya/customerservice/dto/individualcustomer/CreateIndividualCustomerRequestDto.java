package com.etiya.customerservice.dto.individualcustomer;

import jakarta.validation.constraints.Min;
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
public class CreateIndividualCustomerRequestDto {

    @NotEmpty
    private String firstName;
    private String middleName;
    @NotEmpty
    private String lastName;
    @NotNull
    private Date birthDate;
    @NotNull
    private Character gender;
    private String fatherName;
    private String motherName;
    @NotNull
    private Boolean nationality;
    @Size(min = 11,max = 11)
    private String nationalityId;
}
