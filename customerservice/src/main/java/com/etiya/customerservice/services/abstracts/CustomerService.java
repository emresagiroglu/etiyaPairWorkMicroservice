package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.dto.customer.GetCustomerResponseDto;
import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.entity.Customer;

import java.util.List;


public interface CustomerService {

    GetCorporateCustomerResponseDto getCorporateCustomerById(Long id);

    List<ListCorporateCustomerResponseDto> getCorporateCustomersAll();

    CreateCorporateCustomerResponseDto saveCorporateCustomer(CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto);

    UpdateCorporateCustomerResponseDto updateCorporateCustomer(UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto, Long id);

    void deleteCorporateCustomer(Long id);


    GetIndividualCustomerResponseDto getIndividualCustomerById(Long id);

    List<ListIndividualCustomerResponseDto> getIndividualCustomersAll();

    CreateIndividualCustomerResponseDto saveIndividualCustomer(CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto);

    UpdateIndividualCustomerResponseDto updateIndividualCustomer(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto, Long id);

    void deleteIndividualCustomer(Long id);

    GetCustomerResponseDto getCustomerById(Long id);
}
