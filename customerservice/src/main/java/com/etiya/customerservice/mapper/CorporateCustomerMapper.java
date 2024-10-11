package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corpatecustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.services.abstracts.CorporateCustomerService;
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

    CorporateCustomer corporateCustomerFromUpdateRequestDto(UpdateCustomerRequestDto dto);
    UpdateCustomerResponseDto updateCustomerResponseDto(CorporateCustomer corporateCustomer);
}
