package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Long, Customer> {
}
