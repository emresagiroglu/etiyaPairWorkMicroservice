package com.etiya.customerservice.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequestDto {

    @NotBlank
    @NotNull
    private Long customerId;
    @NotBlank
    @NotNull
    private Long neighbourhoodId;
    @NotBlank
    @NotNull
    private String addressName;
    @NotBlank
    @NotNull
    private String street;
    @NotBlank
    @NotNull
    private Integer houseNumber;
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
