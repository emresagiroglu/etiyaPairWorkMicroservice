package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.entity.BillingAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillingAccountServiceImpl {
    private final BillingAccountRepository billingAccountRepository;

    public List<BillingAccountDto> getAll() {
        List<BillingAccount> billingAccountList = billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.getAllBillingAccountDtoFromBillingAccount(billingAccountList);
    }
    public BillingAccountDto getById(UUID id) {
        BillingAccount billingAccount = billingAccountRepository.findById(id).orElseThrow();
        return BillingAccountMapper.INSTANCE.getBillingAccountDtoFromBillingAccount(billingAccount);
    }
    public BillingAccountDto save(BillingAccountDto billingAccountDto) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.getBillingAccountFromBillingAccountDto(billingAccountDto);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.getBillingAccountDtoFromBillingAccount(billingAccount);
    }
    public BillingAccountDto update(BillingAccountDto billingAccountDto, UUID id) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.getBillingAccountFromBillingAccountDto(billingAccountDto);
        billingAccount.setId(id);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.getBillingAccountDtoFromBillingAccount(billingAccount);
    }
    public void delete(UUID id) {
        billingAccountRepository.deleteById(id);
    }
}
