package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecificationRepository extends JpaRepository<Specification, UUID> {
}
