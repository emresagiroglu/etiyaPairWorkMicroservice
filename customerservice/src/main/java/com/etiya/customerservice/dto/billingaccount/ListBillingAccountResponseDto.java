package com.etiya.customerservice.dto.billingaccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListBillingAccountResponseDto {
    private Integer customerId;
    private Integer addressId;
    private Integer contactId;
    private String accountName;
    private String type;
    private String desc;
    private Integer taxNumber;

}
