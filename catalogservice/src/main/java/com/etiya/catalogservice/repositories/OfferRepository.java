package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {
}
