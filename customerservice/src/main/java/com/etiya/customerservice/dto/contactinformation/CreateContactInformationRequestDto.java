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
public class CreateContactInformationRequestDto {
    @NotBlank
    @NotNull
    private Long customerId;
    @NotBlank
    @NotNull
    private String contactName;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private Integer homePhone;
    @NotBlank
    @NotNull
    private Integer mobilePhone;
    @NotBlank
    @NotNull
    private Integer fax;
    @NotBlank
    @NotNull
    private Date createdDate;
    @NotBlank
    @NotNull
    private Date updatedDate;
    @NotBlank
    @NotNull
    private Date deletedDate;

}
