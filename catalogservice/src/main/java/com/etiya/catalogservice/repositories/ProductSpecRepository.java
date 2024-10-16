package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.ProductSpec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductSpecRepository extends JpaRepository<ProductSpec, UUID> {
}
