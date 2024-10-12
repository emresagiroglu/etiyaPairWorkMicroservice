package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.billingaccount.*;
import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.mapper.BillingAccountMapper;
import com.etiya.customerservice.repositories.BillingAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillingAccountServiceImpl {
    private final BillingAccountRepository billingAccountRepository;

    public List<ListBillingAccountResponseDto> getAll() {
        List<BillingAccount> billingAccountList = billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.getBillingAccountResponseDtoFromBillingAccount(billingAccountList);
    }
    public GetBillingAccountResponseDto getById(UUID id) {
        BillingAccount billingAccount = billingAccountRepository.findById(id).orElseThrow();
        return BillingAccountMapper.INSTANCE.getBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public CreateBillingAccountResponseDto save(CreateBillingAccountRequestDto billingAccountDto) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.createBillingAccountFromCreateBillingAccountRequestDto(billingAccountDto);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.createBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public UpdateBillingAccountResponseDto update(UpdateBillingAccountRequestDto billingAccountDto, UUID id) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.updateBillingAccountFromUpdateBillingAccountRequestDto(billingAccountDto);
        billingAccount.setId(id);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.updateBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public void delete(UUID id) {
        billingAccountRepository.deleteById(id);
    }
}
