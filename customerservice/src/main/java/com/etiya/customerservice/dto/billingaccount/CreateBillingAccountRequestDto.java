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
    private Integer customerId;
    @NotBlank
    @NotNull
    private Integer addressId;
    @NotBlank
    @NotNull
    private Integer contactId;
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
    private Integer taxNumber;
    @NotBlank
    @NotNull
    private Date cDate;
    @NotBlank
    @NotNull
    private Date uDate;
    @NotBlank
    @NotNull
    private Date dDate;

}
