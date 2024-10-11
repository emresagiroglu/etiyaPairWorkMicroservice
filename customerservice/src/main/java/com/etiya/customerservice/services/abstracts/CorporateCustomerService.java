package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.corpatecustomer.CreateCorporateCustomerRequestDto;
import com.etiya.customerservice.dto.corpatecustomer.CreateCorporateCustomerResponseDto;
import com.etiya.customerservice.entity.CorporateCustomer;

import java.util.List;
import java.util.UUID;

public interface CorporateCustomerService {

    CorporateCustomer getById(UUID id);

    List<CorporateCustomer> getAll();

    CreateCorporateCustomerResponseDto save(CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto);
}
