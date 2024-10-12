package com.etiya.customerservice.dto.contactinformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListContactInformationResponseDto {
    private Integer customerId;
    private String contactName;
    private String email;
    private Integer homePhone;
    private Integer mobilePhone;
    private Integer fax;
}
