package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.core.exception.type.BusinessException;
import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.dto.customer.GetCustomerResponseDto;
import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;

import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.kafka.CustomerProducer;
import com.etiya.customerservice.mapper.CorporateCustomerMapper;
import com.etiya.customerservice.mapper.CustomerMapper;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repositories.CorporateCustomerRepository;
import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.rule.CustomerBusinessRules;
import com.etiya.customerservice.services.abstracts.CustomerService;
import io.github.emresagiroglu.kafka.events.customer.CustomerDeletedEvent;
import io.github.emresagiroglu.kafka.events.customer.CustomerUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CustomerBusinessRules customerBusinessRules;
    private final CustomerProducer customerProducer;

    // Corporate Customer
    @Override
    public List<ListCorporateCustomerResponseDto> getCorporateCustomersAll() {
        // corporate Customer dönücek
        List<CorporateCustomer> corporateCustomerList = corporateCustomerRepository.findAll();

        // Gelen cevabı response maple
        return CorporateCustomerMapper.INSTANCE.
                getAllCorporateCustomersResponseDtoFromCorporateCustomers(corporateCustomerList);


    }

    @Override
    public GetCorporateCustomerResponseDto getCorporateCustomerById(Long id) {


        GetCorporateCustomerResponseDto getCorporateCustomerResponseDto =
                CorporateCustomerMapper.INSTANCE.
                        getCorporateCustomerResponseDtoFromCorporateCustomer
                                (corporateCustomerRepository.findById(id).orElseThrow());

        return getCorporateCustomerResponseDto;

    }

    @Override
    public CreateCorporateCustomerResponseDto saveCorporateCustomer(CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto) {


        // gelen requesti corporate customer' a maple
        CorporateCustomer corporateCustomer = CorporateCustomerMapper.INSTANCE.
                createCorporateCustomerFromCreateCorporateCustomerRequestDto(createCorporateCustomerRequestDto);

        // corporate customer'ı savele
        corporateCustomerRepository.save(corporateCustomer);

        // dönen cevabı response'a maple
        CreateCorporateCustomerResponseDto createCorporateCustomerResponseDto =
                CorporateCustomerMapper.INSTANCE.
                        createCorporateCustomerResponseDtoFromCorporateCustomer(corporateCustomer);
        return createCorporateCustomerResponseDto;
    }

    @Override
    public UpdateCorporateCustomerResponseDto updateCorporateCustomer(UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto, Long id) {

        // corporateCustomer'ı güncelle
        CorporateCustomer corporateCustomerInDb = corporateCustomerRepository.findById(id).orElseThrow();

        // update işlemini yap
        corporateCustomerInDb.setCompanyName(updateCorporateCustomerRequestDto.getCompanyName());
        corporateCustomerInDb.setTaxNumber(updateCorporateCustomerRequestDto.getTaxNumber());
        corporateCustomerInDb.setContactName(updateCorporateCustomerRequestDto.getContactName());

        corporateCustomerRepository.save(corporateCustomerInDb);

        // cevabı response corporateCustomer olarak dön
        UpdateCorporateCustomerResponseDto savedCustomerResponseDto = CorporateCustomerMapper
                .INSTANCE
                .updateCustomerResponseDtoFromCorporateCustomer(corporateCustomerInDb);

        return savedCustomerResponseDto;
    }

    @Override
    public void deleteCorporateCustomer(Long id) {

        // Kullanıcı Kontrolü
        CorporateCustomer corporateCustomerInDb = corporateCustomerRepository.findById(id).orElseThrow();

        // Kullanıcı silinmesi
        corporateCustomerRepository.deleteById(id);
    }


    // Individual Customer
    @Override
    public GetIndividualCustomerResponseDto getIndividualCustomerById(Long id) {
        IndividualCustomer customerInDb = individualCustomerRepository.findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new BusinessException("Customer not found..."));

        GetIndividualCustomerResponseDto getIndividualCustomerResponseDto =
                IndividualCustomerMapper.INSTANCE.
                        getIndividualCustomerResponseDtoFromIndividualCustomer
                                (customerInDb);

        return getIndividualCustomerResponseDto;

    }

    @Override
    public List<ListIndividualCustomerResponseDto> getIndividualCustomersAll() {
        // Individual Customer dönücek
        List<IndividualCustomer> individualCustomerList = individualCustomerRepository.
                findAllByIsActiveIsTrue().orElseThrow(() -> new BusinessException("Customer not found..."));

        // Gelen cevabı response maple
        List<ListIndividualCustomerResponseDto> listIndividualCustomerResponseDtoList = IndividualCustomerMapper.INSTANCE.
                getAllIndividualCustomersResponseDtoFromIndividualCustomers(individualCustomerList);

        return listIndividualCustomerResponseDtoList;
    }

    @Override
    public CreateIndividualCustomerResponseDto saveIndividualCustomer(CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto) {

        // Check if there's a customer with same nationalityId
       customerBusinessRules.customerWithSameNationalityId(createIndividualCustomerRequestDto.getNationalityId());



        // gelen requesti Individual customer' a maple
        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.
                createIndividualCustomerFromCreateIndividualCustomerRequestDto(createIndividualCustomerRequestDto);

        // Individual customer'ı savele
        individualCustomerRepository.save(individualCustomer);


        // dönen cevabı response'a maple
        CreateIndividualCustomerResponseDto createIndividualCustomerResponseDto =
                IndividualCustomerMapper.INSTANCE.
                        createIndividualCustomerResponseDtoFromIndividualCustomer(individualCustomer);
        return createIndividualCustomerResponseDto;
    }

    @Override
    public UpdateIndividualCustomerResponseDto updateIndividualCustomer(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto, Long id) {
        // IndividualCustomer'ı güncelle
        IndividualCustomer individualCustomerInDb = individualCustomerRepository.findById(id).orElseThrow();

        // update işlemini yap
        individualCustomerInDb.setFirstName(updateIndividualCustomerRequestDto.getFirstName());
        individualCustomerInDb.setMiddleName(updateIndividualCustomerRequestDto.getMiddleName());
        individualCustomerInDb.setLastName(updateIndividualCustomerRequestDto.getLastName());
        individualCustomerInDb.setBirthDate(updateIndividualCustomerRequestDto.getBirthDate());
        individualCustomerInDb.setGender(updateIndividualCustomerRequestDto.getGender());
        individualCustomerInDb.setFatherName(updateIndividualCustomerRequestDto.getFatherName());
        individualCustomerInDb.setMotherName(updateIndividualCustomerRequestDto.getMotherName());
        individualCustomerInDb.setNationality(updateIndividualCustomerRequestDto.getNationality());
        individualCustomerInDb.setNationalityId(updateIndividualCustomerRequestDto.getNationalityId());

        individualCustomerRepository.save(individualCustomerInDb);


        CustomerUpdatedEvent customerUpdatedEvent = new CustomerUpdatedEvent();
        customerUpdatedEvent.setId(individualCustomerInDb.getId().toString());
        customerUpdatedEvent.setFirstName(individualCustomerInDb.getFirstName());
        customerUpdatedEvent.setMiddleName(individualCustomerInDb.getMiddleName());
        customerUpdatedEvent.setLastName(individualCustomerInDb.getLastName());
        customerUpdatedEvent.setNationalityId(individualCustomerInDb.getNationalityId());

        customerProducer.sendMessage(customerUpdatedEvent);

        // cevabı response IndividualCustomer olarak dön
        UpdateIndividualCustomerResponseDto savedCustomerResponseDto = IndividualCustomerMapper
                .INSTANCE
                .updateCustomerResponseDtoFromIndividualCustomer(individualCustomerInDb);

        return savedCustomerResponseDto;
    }

    @Override
    public void deleteIndividualCustomer(Long id) {

        // Kullanıcı Kontrolü
        IndividualCustomer individualCustomerInDb = individualCustomerRepository.findById(id).orElseThrow();

        // Kullanıcının isActive değerinin false'a çevirilmesi
        individualCustomerInDb.setIsActive(false);
        individualCustomerInDb.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomerInDb);

        CustomerDeletedEvent customerDeletedEvent = new CustomerDeletedEvent();
        customerDeletedEvent.setId(id.toString());
        customerProducer.sendMessage(customerDeletedEvent);


    }

    @Override
    public GetCustomerResponseDto getCustomerById(Long id) {


        GetCustomerResponseDto getCustomerResponseDto = CustomerMapper
                .INSTANCE
                .getCustomerResponseDtoFromCustomer(customerRepository.findById(id).orElseThrow());

        return getCustomerResponseDto;
    }


}


