package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_based_offers")
@Entity
public class CustomerBasedOffer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Column(name = "customerId")
    private Long customerId;

    //customer id de var ama orası başka mikroserviste!
}
