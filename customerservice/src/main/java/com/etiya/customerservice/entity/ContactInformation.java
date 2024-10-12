package com.etiya.customerservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.context.annotation.Primary;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CNC_INFO")
public class ContactInformation {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "CNC_INFO_ID")
    private UUID cntInfoId;
    @ManyToOne
    @JoinColumn(name = "CUST_ID")
    private Customer customer_id;
    @Column(name = "CNC_NAME")
    private String contactName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HOME_PHONE")
    private Integer homePhone;
    @Column(name = "MOBILE_PHONE")
    private Integer mobilePhone;
    @Column(name = "FAX")
    private Integer fax;
    @Column(name = "CDATE")
    private Date createdDate;
    @Column(name = "UDATE")
    private Date updatedDate;
    @Column(name = "DDATE")
    private Date deletedDate;

    @OneToMany(mappedBy = "contactId")
    @Column(name = "BIL_ACCNT")
    private List<BillingAccount> billingAccounts;

}
