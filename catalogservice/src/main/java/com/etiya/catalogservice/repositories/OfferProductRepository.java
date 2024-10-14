package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.OfferProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferProductRepository extends JpaRepository<OfferProduct, UUID> {
}
