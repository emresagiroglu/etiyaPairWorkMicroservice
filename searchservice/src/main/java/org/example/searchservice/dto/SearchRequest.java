package org.example.searchservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    String nationalityId;
    String id;
    String accountNumber;
    String mobilePhone;
    String firstName;
    String lastName;
    String orderNumber;
}
