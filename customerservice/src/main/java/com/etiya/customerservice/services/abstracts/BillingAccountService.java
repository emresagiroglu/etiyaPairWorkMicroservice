package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.billingaccount.*;

import java.util.List;
import java.util.UUID;

public interface BillingAccountService {
    GetBillingAccountResponseDto getBillingAccountById(UUID id);

    List<ListBillingAccountResponseDto> getBillingAccountsAll();

    CreateBillingAccountResponseDto saveBillingAccount(CreateBillingAccountRequestDto createBillingAccountRequestDto);

    UpdateBillingAccountResponseDto updateBillingAccount(UpdateBillingAccountRequestDto updateBillingAccountRequestDto, UUID id);

    void deleteBillingAccount(UUID id);
}
