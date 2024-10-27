package com.etiya.customerservice.dto.billingaccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListBillingAccountResponseDto {
    private Long id;
    private Long customerId;
    private Long addressId;
    private Long contactId;
    private String accountName;
    private String accountNumber;
    private String type;
    private String desc;
    private String taxNumber;

}
