package com.etiya.customerservice.services.concretes;


import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;


    @Override
    public IndividualCustomer getById(UUID id) {
        return individualCustomerRepository.findById(id).orElseThrow();
    }


    @Override
    public List<IndividualCustomer> getAll() {
        return individualCustomerRepository.findAll();
    }
}
