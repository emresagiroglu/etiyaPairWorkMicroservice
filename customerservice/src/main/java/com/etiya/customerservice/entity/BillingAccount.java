package com.etiya.customerservice.entity;

import com.etiya.customerservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "BIL_ACCNT")
@Entity
public class BillingAccount extends BaseEntity {
//TODO : STATUS ID EKLENECEK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
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
    @Column(name = "DESCRIPTION")
    private String desc;
    @Column(name = "TAX_NUMBER")
    private String taxNumber;

}
