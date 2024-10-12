package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingAccountRepository extends JpaRepository<BillingAccount, UUID> {
}
