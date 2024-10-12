package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "BIL_ACCNT")
@Entity
public class BillingAccount {
//TODO : STATUS ID EKLENECEK
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "BIL_ACCNT_ID")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "CUST_ID")
    private Customer customerId;
    @ManyToOne
    @JoinColumn(name = "ADDR_ID")
    private Address addressId;
    @ManyToOne
    @JoinColumn(name = "CNC_INFO_ID")
    private ContactInformation contactId;
    @Column(name = "ACCNT_NAME")
    private String accountName;
    @Column(name = "BIL_ACCNT_TP")
    private String type;
    @Column(name = "DESC")
    private String desc;
    @Column(name = "TAX_NUMBER")
    private Integer taxNumber;
    @Column(name = "CDate")
    private Date cDate;
    @Column(name = "UDate")
    private Date uDate;
    @Column(name = "DDate")
    private Date dDate;
}
