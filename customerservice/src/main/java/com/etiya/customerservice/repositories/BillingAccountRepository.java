package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BillingAccountRepository extends JpaRepository<BillingAccount, Long> {
}
