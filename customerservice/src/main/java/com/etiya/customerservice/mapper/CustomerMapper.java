package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corporatecustomer.GetCorporateCustomerResponseDto;
import com.etiya.customerservice.dto.customer.GetCustomerResponseDto;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "id", target = "id")
    GetCustomerResponseDto getCustomerResponseDtoFromCustomer
            (Customer customer);
}
