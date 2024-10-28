package org.example.searchservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchResponse {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private String nationalityId;
    private String accountNumber;
    private String mobilePhone;
}
