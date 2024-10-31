package org.example.searchservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "search-customer")
public class Customer {
    @Id
    private String id;
    @Field(name = "nationalityId")
    private String nationalityId;
    @Field(name = "accountNumber")
    private String accountNumber;
    @Field(name = "phoneNumber")
    private String phoneNumber;
    @Field(name = "firstName")
    private String firstName;
    @Field(name = "middleName")
    private String middleName;
    @Field(name = "lastName")
    private String lastName;
    @Field(name = "deletedDate")
    private LocalDateTime deletedDate;
}
