package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.billingaccount.*;
import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.mapper.BillingAccountMapper;
import com.etiya.customerservice.repositories.BillingAccountRepository;
import com.etiya.customerservice.services.abstracts.BillingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BillingAccountServiceImpl implements BillingAccountService {
    private final BillingAccountRepository billingAccountRepository;

    public List<ListBillingAccountResponseDto> getBillingAccountsAll() {
        List<BillingAccount> billingAccountList = billingAccountRepository.findAll();
        return BillingAccountMapper.INSTANCE.listBillingAccountResponseDtoFromBillingAccountList(billingAccountList);
    }
    public GetBillingAccountResponseDto getBillingAccountById(Long id) {
        BillingAccount billingAccount = billingAccountRepository.findById(id).orElseThrow();
        return BillingAccountMapper.INSTANCE.getBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public CreateBillingAccountResponseDto saveBillingAccount(CreateBillingAccountRequestDto billingAccountDto) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.createBillingAccountFromCreateBillingAccountRequestDto(billingAccountDto);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.createBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public UpdateBillingAccountResponseDto updateBillingAccount(UpdateBillingAccountRequestDto billingAccountDto, Long id) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.updateBillingAccountFromUpdateBillingAccountRequestDto(billingAccountDto);
        billingAccount.setId(id);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.updateBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public void deleteBillingAccount(Long id) {
        billingAccountRepository.deleteById(id);
    }
}
