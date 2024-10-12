package com.etiya.customerservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "UpdatedDate")
    private Date updatedDate;

    @Column(name = "DeletedDate")
    private Date deletedDate;


    @OneToMany(mappedBy = "customerId")
    private List<Address> addresses;

    @OneToMany(mappedBy = "customerId")
    private List<ContactInformation> contactInformations;

    @OneToMany(mappedBy = "customerId")
    private List<BillingAccount> billingAccounts;
}
