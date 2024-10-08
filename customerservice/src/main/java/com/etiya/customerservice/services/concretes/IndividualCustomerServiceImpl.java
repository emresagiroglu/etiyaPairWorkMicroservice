package com.etiya.customerservice.services.concretes;


import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;

    @Autowired
    public IndividualCustomerServiceImpl(IndividualCustomerRepository individualCustomerRepository)
    {
        this.individualCustomerRepository = individualCustomerRepository;
    }
}
