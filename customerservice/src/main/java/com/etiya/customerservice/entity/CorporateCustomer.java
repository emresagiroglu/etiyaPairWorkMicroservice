package com.etiya.customerservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CorporateCustomers")
public class CorporateCustomer extends Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "TaxNumber")
    private String taxNumber;
    @Column(name = "ContactName")
    private String contactName;
    @Column(name = "CompanyName")
    private String companyName;

}
