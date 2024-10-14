package com.etiya.catalogservice.repositories;

import com.etiya.catalogservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
