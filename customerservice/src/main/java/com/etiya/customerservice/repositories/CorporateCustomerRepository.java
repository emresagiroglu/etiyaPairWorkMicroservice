package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Long> {
}
