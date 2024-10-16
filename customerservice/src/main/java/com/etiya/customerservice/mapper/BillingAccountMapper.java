package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.billingaccount.*;
import com.etiya.customerservice.entity.BillingAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BillingAccountMapper {
    BillingAccountMapper INSTANCE = Mappers.getMapper(BillingAccountMapper.class);

    @Mapping(source = "customerId.id" ,target = "customerId")
    @Mapping(source = "addressId.id", target = "addressId")
    @Mapping(source = "contactId.id", target = "contactId")
    CreateBillingAccountResponseDto createBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);
    @Mapping(source = "customerId" ,target = "customerId.id")
    @Mapping(source = "addressId", target = "addressId.id")
    @Mapping(source = "contactId", target = "contactId.id")
    BillingAccount createBillingAccountFromCreateBillingAccountRequestDto(CreateBillingAccountRequestDto createBillingAccountRequestDto);
    @Mapping(source = "customerId.id" ,target = "customerId")
    @Mapping(source = "addressId.id", target = "addressId")
    @Mapping(source = "contactId.id", target = "contactId")
    GetBillingAccountResponseDto getBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);
    @Mapping(source = "customerId.id" ,target = "customerId")
    @Mapping(source = "addressId.id", target = "addressId")
    @Mapping(source = "contactId.id", target = "contactId")
    ListBillingAccountResponseDto BillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);
    @Mapping(source = "customerId.id" ,target = "customerId")
    @Mapping(source = "addressId.id", target = "addressId")
    @Mapping(source = "contactId.id", target = "contactId")
    List<ListBillingAccountResponseDto> listBillingAccountResponseDtoFromBillingAccountList(List<BillingAccount> billingAccountList);
    @Mapping(source = "customerId.id" ,target = "customerId")
    @Mapping(source = "addressId.id", target = "addressId")
    @Mapping(source = "contactId.id", target = "contactId")
    UpdateBillingAccountResponseDto updateBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);
    @Mapping(source = "customerId" ,target = "customerId.id")
    @Mapping(source = "addressId", target = "addressId.id")
    @Mapping(source = "contactId", target = "contactId.id")
    BillingAccount updateBillingAccountFromUpdateBillingAccountRequestDto(UpdateBillingAccountRequestDto updateBillingAccountRequestDto);
}
