package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {
    Optional<IndividualCustomer> findByNationalityId(String nationalityId);
    Optional<IndividualCustomer> findByIdAndIsActiveTrue(Long id);
    Optional<List<IndividualCustomer>> findAllByIsActiveIsTrue();
}
