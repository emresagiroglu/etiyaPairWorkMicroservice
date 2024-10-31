package com.etiya.customerservice.dto.address;

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
public class CreateAddressRequestDto {

    @NotNull
    private Long customerId;
    @NotNull
    private Long neighbourhoodId;
    @NotEmpty
    private String addressName;
    @NotEmpty
    private String addressDesc;
    @NotEmpty
    private String street;
    @NotNull
    private Long houseNumber;
}
