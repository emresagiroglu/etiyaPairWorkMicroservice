package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entity.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactInformationRepository extends JpaRepository<ContactInformation, UUID> {
}
