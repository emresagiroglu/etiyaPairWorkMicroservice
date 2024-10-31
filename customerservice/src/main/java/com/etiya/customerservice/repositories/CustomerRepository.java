package com.etiya.customerservice.repositories;

import com.etiya.customerservice.dto.customer.GetCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByIsActiveIsTrue();
    Optional<List<Customer>> findAllByIsActiveIsTrue();
}
