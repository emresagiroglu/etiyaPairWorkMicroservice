package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, UUID> {
}
