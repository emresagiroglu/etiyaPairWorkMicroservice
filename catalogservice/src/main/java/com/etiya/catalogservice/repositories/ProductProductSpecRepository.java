package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.ProductProductSpec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductProductSpecRepository extends JpaRepository<ProductProductSpec, UUID> {
}
