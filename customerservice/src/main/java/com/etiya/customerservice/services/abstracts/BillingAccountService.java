package com.etiya.customerservice.services.abstracts;

public interface BillingAccountService {
    GetBillingAccountResponseDto getBillingAccountById(UUID id);

    List<ListBillingAccountResponseDto> getBillingAccountsAll();

    CreateBillingAccountResponseDto saveBillingAccount(CreateBillingAccountRequestDto createBillingAccountRequestDto);

    UpdateBillingAccountResponseDto updateBillingAccount(UpdateBillingAccountRequestDto updateBillingAccountRequestDto, UUID id);

    void deleteBillingAccount(UUID id);
}
