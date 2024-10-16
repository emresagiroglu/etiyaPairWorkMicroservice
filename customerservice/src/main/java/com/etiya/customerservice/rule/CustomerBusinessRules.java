package com.etiya.customerservice.rule;

import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.repositories.CorporateCustomerRepository;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerBusinessRules {

    private final IndividualCustomerRepository individualCustomerRepository;
    private final CorporateCustomerRepository corporateCustomerRepository;

    public void customerWithSameNationalityId(String nationalityId)
    {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityId(nationalityId);

        if(individualCustomer.isPresent()){
            throw new RuntimeException("A customer already exists with this Nationality ID");
        }
    }
}
