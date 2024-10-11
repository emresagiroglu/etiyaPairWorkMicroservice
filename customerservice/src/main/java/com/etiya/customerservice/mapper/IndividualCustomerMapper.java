package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface IndividualCustomerMapper {


    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);
    IndividualCustomer createIndividualCustomerFromCreateIndividualCustomerRequestDto
            (CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto);

    GetIndividualCustomerResponseDto getIndividualCustomerResponseDtoFromIndividualCustomer
            (IndividualCustomer individualCustomer);

    List<ListIndividualCustomerResponseDto> getAllIndividualCustomersResponseDtoFromIndividualCustomers
            (List<IndividualCustomer> individualCustomers);

    IndividualCustomer individualCustomerFromUpdateRequestDto(UpdateIndividualCustomerRequestDto dto);
    CreateIndividualCustomerResponseDto createIndividualCustomerResponseDtoFromIndividualCustomer
            (IndividualCustomer individualCustomer);

    IndividualCustomer individualCustomerFromUpdateCustomerRequestDto(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto);

    UpdateIndividualCustomerResponseDto updateCustomerResponseDtoFromIndividualCustomer(IndividualCustomer individualCustomer);
}
