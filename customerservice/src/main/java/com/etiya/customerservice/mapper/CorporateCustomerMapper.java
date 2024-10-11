package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CorporateCustomerMapper {
    //TODO target varsa ekle!

    CorporateCustomerMapper INSTANCE = Mappers.getMapper(CorporateCustomerMapper.class);
    CorporateCustomer createCorporateCustomerFromCreateCorporateCustomerRequestDto
            (CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto);

    GetCorporateCustomerResponseDto getCorporateCustomerResponseDtoFromCorporateCustomer
            (CorporateCustomer corporateCustomer);

    List<ListCorporateCustomerResponseDto> getAllCorporateCustomersResponseDtoFromCorporateCustomers
            (List<CorporateCustomer> corporateCustomers);

    CorporateCustomer corporateCustomerFromUpdateRequestDto(UpdateCorporateCustomerRequestDto dto);
    CreateCorporateCustomerResponseDto createCorporateCustomerResponseDtoFromCorporateCustomer
            (CorporateCustomer corporateCustomer);

    CorporateCustomer corporateCustomerFromUpdateCustomerRequestDto(UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto);

    UpdateCorporateCustomerResponseDto updateCustomerResponseDtoFromCorporateCustomer(CorporateCustomer corporateCustomer);

}
