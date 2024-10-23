package com.etiya.customerservice.dto.contactinformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateContactInformationResponseDto {
    private Long id;
    private Long customerId;
    private String contactName;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
