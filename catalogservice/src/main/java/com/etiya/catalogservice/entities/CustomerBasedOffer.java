package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_based_offers")
@Entity
public class CustomerBasedOffer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    //customer id de var ama orası başka mikroserviste!
}
