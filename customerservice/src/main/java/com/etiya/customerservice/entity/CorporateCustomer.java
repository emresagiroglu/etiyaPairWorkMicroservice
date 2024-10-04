package com.etiya.customerservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CorporateCustomers")
public class CorporateCustomer extends Customer {

    @Column(name = "TaxNumber")
    private Long taxNumber;
    @Column(name = "ContactName")
    private String contactName;
    @Column(name = "CompanyName")
    private String companyName;

}
