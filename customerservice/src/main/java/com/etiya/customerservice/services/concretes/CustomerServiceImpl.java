package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.repositories.CorporateCustomerRepository;
import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
}


