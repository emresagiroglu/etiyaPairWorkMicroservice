package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.repositories.CorporateCustomerRepository;
import com.etiya.customerservice.services.abstracts.CorporateCustomerService;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CorporateCustomerServiceImpl implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    @Autowired
    public CorporateCustomerServiceImpl(CorporateCustomerRepository corporateCustomerRepository)
    {
        this.corporateCustomerRepository = corporateCustomerRepository;
    }
}
