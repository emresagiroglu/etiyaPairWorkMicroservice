package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.billingaccount.*;

import java.util.List;


public interface BillingAccountService {
    GetBillingAccountResponseDto getBillingAccountById(Long id);

    List<ListBillingAccountResponseDto> getBillingAccountsAll();

    CreateBillingAccountResponseDto saveBillingAccount(CreateBillingAccountRequestDto createBillingAccountRequestDto);

    UpdateBillingAccountResponseDto updateBillingAccount(UpdateBillingAccountRequestDto updateBillingAccountRequestDto, Long id);

    void deleteBillingAccount(Long id);
}
