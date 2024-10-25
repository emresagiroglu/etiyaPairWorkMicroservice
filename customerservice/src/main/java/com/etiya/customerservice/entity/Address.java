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
@NoArgsConstructor
@Data
@Table(name = "Address")
@Entity
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    private Long houseNumber;


    @OneToMany(mappedBy = "addressId")
    private List<BillingAccount> billingAccounts;

}
