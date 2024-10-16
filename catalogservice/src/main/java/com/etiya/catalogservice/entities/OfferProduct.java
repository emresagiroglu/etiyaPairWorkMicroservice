package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "offer_products")
@Entity
public class OfferProduct extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "discount_percentage")
    private int discountPercentage;

    @Column(name = "discount_desc")
    private String discountDesc;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
