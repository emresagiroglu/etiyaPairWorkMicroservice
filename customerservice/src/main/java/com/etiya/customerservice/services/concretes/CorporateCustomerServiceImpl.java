package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.repositories.CorporateCustomerRepository;
import com.etiya.customerservice.services.abstracts.CorporateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
}
