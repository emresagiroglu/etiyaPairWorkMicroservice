package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.billingaccount.*;
import com.etiya.customerservice.entity.BillingAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BillingAccountMapper {
    BillingAccountMapper INSTANCE = Mappers.getMapper(BillingAccountMapper.class);

    CreateBillingAccountResponseDto createBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);
    BillingAccount createBillingAccountFromCreateBillingAccountRequestDto(CreateBillingAccountRequestDto createBillingAccountRequestDto);
    GetBillingAccountResponseDto getBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);
    List<ListBillingAccountResponseDto> listBillingAccountResponseDtoFromBillingAccountList(List<BillingAccount> billingAccountList);
    UpdateBillingAccountResponseDto updateBillingAccountResponseDtoFromBillingAccount(BillingAccount billingAccount);
    BillingAccount updateBillingAccountFromUpdateBillingAccountRequestDto(UpdateBillingAccountRequestDto updateBillingAccountRequestDto);
}
