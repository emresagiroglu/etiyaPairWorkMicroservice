package com.etiya.customerservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "IndividualCustomers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class IndividualCustomer extends Customer {

    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "BirthDate")
    private Date birthDate;
    @Column(name = "Gender")
    private Character gender;
    @Column(name = "FatherName")
    private String fatherName;
    @Column(name = "MotherName")
    private String motherName;
    @Column(name = "Nationality")
    private Boolean nationality;
    @Column(name = "NationalityID")
    private String nationalityId;
}
