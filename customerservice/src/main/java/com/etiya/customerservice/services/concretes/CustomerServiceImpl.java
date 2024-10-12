package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.corporatecustomer.*;
import com.etiya.customerservice.dto.individualcustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.CorporateCustomerMapper;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repositories.CorporateCustomerRepository;
import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final IndividualCustomerRepository individualCustomerRepository;

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
    public GetCorporateCustomerResponseDto getCorporateCustomerById(UUID id) {


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
    public UpdateCorporateCustomerResponseDto updateCorporateCustomer(UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto, UUID id) {

        // corporateCustomer'ı güncelle
        CorporateCustomer corporateCustomerInDb = corporateCustomerRepository.findById(id).orElseThrow();

        // update işlemini yap
        corporateCustomerInDb.setCompanyName(updateCorporateCustomerRequestDto.getCompanyName());
        corporateCustomerInDb.setTaxNumber(updateCorporateCustomerRequestDto.getTaxNumber());
        corporateCustomerInDb.setContactName(updateCorporateCustomerRequestDto.getContactName());

        // cevabı response corporateCustomer olarak dön
        UpdateCorporateCustomerResponseDto savedCustomerResponseDto = CorporateCustomerMapper
                .INSTANCE
                .updateCustomerResponseDtoFromCorporateCustomer(corporateCustomerInDb);

        return savedCustomerResponseDto;
    }

    @Override
    public void deleteCorporateCustomer(UUID id) {

        // Kullanıcı Kontrolü
        CorporateCustomer corporateCustomerInDb = corporateCustomerRepository.findById(id).orElseThrow();

        // Kullanıcı silinmesi
        corporateCustomerRepository.deleteById(id);
    }


    // Individual Customer
    @Override
    public GetIndividualCustomerResponseDto getIndividualCustomerById(UUID id) {
        GetIndividualCustomerResponseDto getIndividualCustomerResponseDto =
                IndividualCustomerMapper.INSTANCE.
                        getIndividualCustomerResponseDtoFromIndividualCustomer
                                (individualCustomerRepository.findById(id).orElseThrow());

        return getIndividualCustomerResponseDto;

    }

    @Override
    public List<ListIndividualCustomerResponseDto> getIndividualCustomersAll() {
        // Individual Customer dönücek
        List<IndividualCustomer> individualCustomerList = individualCustomerRepository.findAll();

        // Gelen cevabı response maple
        List<ListIndividualCustomerResponseDto> listIndividualCustomerResponseDtoList = IndividualCustomerMapper.INSTANCE.
                getAllIndividualCustomersResponseDtoFromIndividualCustomers(individualCustomerList);

        return listIndividualCustomerResponseDtoList;
    }

    @Override
    public CreateIndividualCustomerResponseDto saveIndividualCustomer(CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto) {
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
    public UpdateIndividualCustomerResponseDto updateIndividualCustomer(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto, UUID id) {
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


        // cevabı response IndividualCustomer olarak dön
        UpdateIndividualCustomerResponseDto savedCustomerResponseDto = IndividualCustomerMapper
                .INSTANCE
                .updateCustomerResponseDtoFromIndividualCustomer(individualCustomerInDb);

        return savedCustomerResponseDto;
    }

    @Override
    public void deleteIndividualCustomer(UUID id) {

        // Kullanıcı Kontrolü
        IndividualCustomer individualCustomerInDb = individualCustomerRepository.findById(id).orElseThrow();

        // Kullanıcı silinmesi
        individualCustomerRepository.deleteById(id);

    }


}


