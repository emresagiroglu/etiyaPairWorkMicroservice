package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Campaign;
import com.etiya.catalogservice.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {

    Optional<Offer> findByIdAndIsActiveTrue(UUID id);
    Optional<List<Offer>> findAllByIsActiveTrue();
}
