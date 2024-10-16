package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.CustomerBasedOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerBasedOfferRepository extends JpaRepository<CustomerBasedOffer, UUID> {
}
