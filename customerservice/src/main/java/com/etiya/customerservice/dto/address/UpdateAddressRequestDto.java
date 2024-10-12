package com.etiya.customerservice.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressRequestDto {

            private Integer customerId;
            private Integer neighbourhoodId;
            private String addressName;
            private String street;
            private Integer houseNumber;
}
