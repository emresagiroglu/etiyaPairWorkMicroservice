package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.corpatecustomer.CreateCorporateCustomerRequestDto;
import com.etiya.customerservice.dto.corpatecustomer.CreateCorporateCustomerResponseDto;
import com.etiya.customerservice.dto.corpatecustomer.GetCorporateCustomerResponseDto;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.repositories.CorporateCustomerRepository;
import com.etiya.customerservice.services.abstracts.CorporateCustomerService;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;


    @Override
    public GetCorporateCustomerResponseDto getById(UUID id) {

        return corporateCustomerRepository.findById(id).orElseThrow();

    }

    @Override
    public List<CorporateCustomer> getAll() {
        return corporateCustomerRepository.findAll();
    }

    @Override
    public CreateCorporateCustomerResponseDto save(CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto) {

//        // dto to entity
//        // save entity
//        corporateCustomerRepository.save()
        return null;
    }

}
