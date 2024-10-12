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

    private Integer customerId;
    private String contactName;
    private String email;
    private Integer homePhone;
    private Integer mobilePhone;
    private Integer fax;

}
