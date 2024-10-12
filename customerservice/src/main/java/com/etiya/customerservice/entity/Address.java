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
@Table(name = "Address")
@Entity
public class Address {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "ADDRESS_ID")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "CUST_ID")
    private Customer customerId;
    @ManyToOne
    @JoinColumn(name = "NEIGHBOURHOOD_ID")
    private Neighbourhood neighbourhoodId;
    @Column(name = "ADDR_NAME")
    private String addressName;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private Integer houseNumber;
    @Column(name = "CDate")
    private Date cDate;
    @Column(name = "UDate")
    private Date uDate;
    @Column(name = "DDate")
    private Date dDate;

    @OneToMany(mappedBy = "addressId")
    private List<BillingAccount> billingAccounts;

}
