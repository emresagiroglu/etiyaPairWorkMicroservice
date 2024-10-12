package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.Neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NeighbourhoodRepository extends JpaRepository<Neighbourhood, UUID> {
}
