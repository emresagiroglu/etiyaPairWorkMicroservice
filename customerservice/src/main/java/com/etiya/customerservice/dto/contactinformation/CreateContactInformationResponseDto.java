package com.etiya.customerservice.dto.contactinformation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactInformationResponseDto {
    private Long id;
    private Long customerId;
    private String contactName;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;

}
