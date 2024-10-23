package com.etiya.customerservice.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressResponseDto {
        private Long id;
        private Long customerId;
        private Long neighbourhoodId;
        private String addressName;
        private String street;
        private Long houseNumber;

}
