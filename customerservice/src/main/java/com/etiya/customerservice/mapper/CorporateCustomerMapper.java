package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CorporateCustomerMapper {
    //TODO target varsa ekle!

    CorporateCustomerMapper INSTANCE = Mappers.getMapper(CorporateCustomerMapper.class);

    CorporateCustomer createCorporateCustomerFromCreateCorporateCustomerRequestDto
            (CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto);
    @Mapping(source = "id", target = "id")
    GetCorporateCustomerResponseDto getCorporateCustomerResponseDtoFromCorporateCustomer
            (CorporateCustomer corporateCustomer);
    @Mapping(source = "id", target = "id")
    ListCorporateCustomerResponseDto listCorporateCustomersResponseDtoFromCorporateCustomers(CorporateCustomer corporateCustomer);
    @Mapping(source = "id", target = "id")
    List<ListCorporateCustomerResponseDto> getAllCorporateCustomersResponseDtoFromCorporateCustomers
            (List<CorporateCustomer> corporateCustomers);

    CorporateCustomer corporateCustomerFromUpdateRequestDto(UpdateCorporateCustomerRequestDto dto);
    @Mapping(source = "id", target = "id")
    CreateCorporateCustomerResponseDto createCorporateCustomerResponseDtoFromCorporateCustomer
            (CorporateCustomer corporateCustomer);

    CorporateCustomer corporateCustomerFromUpdateCustomerRequestDto(UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto);
    @Mapping(source = "id", target = "id")
    UpdateCorporateCustomerResponseDto updateCustomerResponseDtoFromCorporateCustomer(CorporateCustomer corporateCustomer);

}
