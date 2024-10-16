package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface IndividualCustomerMapper {


    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);

    IndividualCustomer createIndividualCustomerFromCreateIndividualCustomerRequestDto
            (CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto);
    @Mapping(source = "id", target = "id")
    GetIndividualCustomerResponseDto getIndividualCustomerResponseDtoFromIndividualCustomer
            (IndividualCustomer individualCustomer);
    @Mapping(source = "id", target = "id")
    ListIndividualCustomerResponseDto listIndividualCustomersResponseDtoFromIndividualCustomers(IndividualCustomer individualCustomer);
    @Mapping(source = "id", target = "id")
    List<ListIndividualCustomerResponseDto> getAllIndividualCustomersResponseDtoFromIndividualCustomers
            (List<IndividualCustomer> individualCustomers);

    @Mapping(source = "id", target = "id")
    CreateIndividualCustomerResponseDto createIndividualCustomerResponseDtoFromIndividualCustomer
            (IndividualCustomer individualCustomer);

    IndividualCustomer individualCustomerFromUpdateCustomerRequestDto(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto);
    @Mapping(source = "id", target = "id")
    UpdateIndividualCustomerResponseDto updateCustomerResponseDtoFromIndividualCustomer(IndividualCustomer individualCustomer);
}
