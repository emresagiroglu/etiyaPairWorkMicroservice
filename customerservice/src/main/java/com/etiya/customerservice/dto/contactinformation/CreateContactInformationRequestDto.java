package com.etiya.customerservice.dto.contactinformation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactInformationRequestDto {
    @NotNull
    private Long customerId;
    @NotEmpty
    private String contactName;
    @NotEmpty
    private String email;
    private Integer homePhone;
    @NotNull
    private Integer mobilePhone;
    private Integer fax;
}
