package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, UUID> {
}
