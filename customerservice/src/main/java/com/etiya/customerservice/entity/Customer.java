package com.etiya.customerservice.entity;


import com.etiya.customerservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Data
@Table(name = "customers")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "customerId")
    private List<Address> addresses;

    @OneToMany(mappedBy = "customerId")
    private List<ContactInformation> contactInformations;

    @OneToMany(mappedBy = "customerId")
    private List<BillingAccount> billingAccounts;

    // Başlangıç ID değeri
    private static long currentId = 100000000000L;

    // Constructor
    public Customer() {
        this.id = currentId++;
    }
}
