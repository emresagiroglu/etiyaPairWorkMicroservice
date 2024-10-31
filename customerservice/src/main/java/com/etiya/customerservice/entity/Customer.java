package com.etiya.customerservice.entity;


import io.github.emresagiroglu.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Data
@Table(name = "customers")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

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
        this.isActive = true;
    }
}
