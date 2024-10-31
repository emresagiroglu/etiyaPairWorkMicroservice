package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.core.exception.type.BusinessException;
import com.etiya.customerservice.dto.billingaccount.*;
import com.etiya.customerservice.dto.individualcustomer.GetIndividualCustomerResponseDto;
import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.kafka.BillingAccountProducer;
import com.etiya.customerservice.mapper.BillingAccountMapper;
import com.etiya.customerservice.repositories.BillingAccountRepository;
import com.etiya.customerservice.services.abstracts.BillingAccountService;
import com.etiya.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import io.github.emresagiroglu.kafka.events.billingaccount.BillingAccountCreatedEvent;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BillingAccountServiceImpl implements BillingAccountService {
    private final BillingAccountRepository billingAccountRepository;
    private final BillingAccountProducer billingAccountProducer;
    private final CustomerService customerService;

    public List<ListBillingAccountResponseDto> getBillingAccountsAll() {
        List<BillingAccount> billingAccountList = billingAccountRepository.
                findAllByIsActiveTrue()
                .orElseThrow(() -> new BusinessException("There is no active Billing Account"));
        return BillingAccountMapper.INSTANCE.listBillingAccountResponseDtoFromBillingAccountList(billingAccountList);
    }
    public GetBillingAccountResponseDto getBillingAccountById(Long id) {
        BillingAccount billingAccount = billingAccountRepository.
                findByIdAndIsActiveTrue(id).
                orElseThrow(() -> new BusinessException("There is no active Billing Account with this id: " + id));

        return BillingAccountMapper.INSTANCE.getBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public CreateBillingAccountResponseDto saveBillingAccount(CreateBillingAccountRequestDto billingAccountDto) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.createBillingAccountFromCreateBillingAccountRequestDto(billingAccountDto);
        billingAccountRepository.save(billingAccount);

        //Kafka için setleme işlemi
        CreateBillingAccountResponseDto createBillingAccountResponseDto =
                BillingAccountMapper.INSTANCE.createBillingAccountResponseDtoFromBillingAccount(billingAccount);

        createBillingAccountResponseDto.setId(billingAccount.getId());
        createBillingAccountResponseDto.setCustomerId(billingAccount.getCustomerId().getId());

        //customerid ye göre customer bulma
        GetIndividualCustomerResponseDto individualCustomer = customerService.getIndividualCustomerById(billingAccount.getCustomerId().getId());
        BillingAccountCreatedEvent billingAccountCreatedEvent = new BillingAccountCreatedEvent();
        billingAccountCreatedEvent.setCustomerId(individualCustomer.getId().toString());
        billingAccountCreatedEvent.setAccountNumber(createBillingAccountResponseDto.getAccountNumber());

        billingAccountProducer.sendMessage(billingAccountCreatedEvent);
        return BillingAccountMapper.INSTANCE.createBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public UpdateBillingAccountResponseDto updateBillingAccount(UpdateBillingAccountRequestDto billingAccountDto, Long id) {
        BillingAccount billingAccount = BillingAccountMapper.INSTANCE.updateBillingAccountFromUpdateBillingAccountRequestDto(billingAccountDto);
        billingAccount.setId(id);
        billingAccountRepository.save(billingAccount);
        return BillingAccountMapper.INSTANCE.updateBillingAccountResponseDtoFromBillingAccount(billingAccount);
    }
    public void deleteBillingAccount(Long id) {
        BillingAccount billingAccount = billingAccountRepository.
                findByIdAndIsActiveTrue(id).
                orElseThrow(() -> new BusinessException("There is no active Billing Account with this id: " + id));

        billingAccount.setIsActive(false);

        billingAccountRepository.save(billingAccount);
    }
}
