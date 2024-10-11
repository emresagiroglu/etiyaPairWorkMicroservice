package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.IndividualCustomer;

import java.util.List;
import java.util.UUID;

public interface IndividualCustomerService {
    IndividualCustomer getById(UUID id);

    List<IndividualCustomer> getAll();
}
