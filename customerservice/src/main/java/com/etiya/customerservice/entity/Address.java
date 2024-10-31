package com.etiya.customerservice.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import io.github.emresagiroglu.entity.BaseEntity;

import java.util.Date;
import java.util.List;


@AllArgsConstructor

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
    @Column(name = "ADDR_DESC")
    private String addressDesc;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private Long houseNumber;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToMany(mappedBy = "addressId")
    private List<BillingAccount> billingAccounts;

    public Address(){
        this.isActive = true;
    }

}
