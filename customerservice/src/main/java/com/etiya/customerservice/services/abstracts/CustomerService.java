package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.dto.individualcustomer.*;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    GetCorporateCustomerResponseDto getCorporateCustomerById(UUID id);

    List<ListCorporateCustomerResponseDto> getCorporateCustomersAll();

    CreateCorporateCustomerResponseDto saveCorporateCustomer(CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto);

    UpdateCorporateCustomerResponseDto updateCorporateCustomer(UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto, UUID id);

    void deleteCorporateCustomer(UUID id);


    GetIndividualCustomerResponseDto getIndividualCustomerById(UUID id);

    List<ListIndividualCustomerResponseDto> getIndividualCustomersAll();

    CreateIndividualCustomerResponseDto saveIndividualCustomer(CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto);

    UpdateIndividualCustomerResponseDto updateIndividualCustomer(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto, UUID id);

    void deleteIndividualCustomer(UUID id);
}
