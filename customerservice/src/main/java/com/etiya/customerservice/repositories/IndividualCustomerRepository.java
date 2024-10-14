package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {
}
