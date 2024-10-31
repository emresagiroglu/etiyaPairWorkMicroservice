package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Table(name = "offers")
@Entity
public class Offer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "offer")
    private List<OfferProduct> offerProducts;

    @OneToMany(mappedBy = "offer")
    private List<CustomerBasedOffer> customerBasedOffers;

    public Offer(){
        this.setIsActive(true);
    }
}
