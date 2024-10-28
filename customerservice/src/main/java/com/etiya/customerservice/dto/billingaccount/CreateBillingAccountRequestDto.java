package com.etiya.customerservice.dto.billingaccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBillingAccountRequestDto {
    @NotBlank
    @NotNull
    private Long customerId;
    @NotBlank
    @NotNull
    private Long addressId;
    @NotBlank
    @NotNull
    private String accountNumber;
    @NotBlank
    @NotNull
    private Long contactId;
    @NotBlank
    @NotNull
    private String accountName;
    @NotBlank
    @NotNull
    private String type;
    @NotBlank
    @NotNull
    private String desc;
    @NotBlank
    @NotNull
    private String taxNumber;

}
