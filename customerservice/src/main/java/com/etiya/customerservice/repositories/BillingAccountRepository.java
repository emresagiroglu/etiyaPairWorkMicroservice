package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BillingAccountRepository extends JpaRepository<BillingAccount, Long> {

    Optional<List<BillingAccount>> findAllByIsActiveTrue();
    Optional<BillingAccount> findByIdAndIsActiveTrue(Long id);
}
