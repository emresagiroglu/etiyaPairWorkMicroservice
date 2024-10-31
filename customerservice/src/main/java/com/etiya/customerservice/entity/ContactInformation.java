package com.etiya.customerservice.entity;


import io.github.emresagiroglu.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.context.annotation.Primary;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CNC_INFO")
public class ContactInformation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUST_ID")
    private Customer customerId;
    @Column(name = "CNC_NAME")
    private String contactName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;
    @Column(name = "FAX")
    private String fax;

    @OneToMany(mappedBy = "contactId")
    private List<BillingAccount> billingAccounts;

}
