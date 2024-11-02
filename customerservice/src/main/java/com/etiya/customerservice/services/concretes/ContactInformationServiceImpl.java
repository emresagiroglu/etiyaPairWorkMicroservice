package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.contactinformation.*;
import com.etiya.customerservice.dto.individualcustomer.GetIndividualCustomerResponseDto;
import com.etiya.customerservice.entity.ContactInformation;
import com.etiya.customerservice.kafka.ContactMediumProducer;
import com.etiya.customerservice.kafka.CustomerProducer;
import com.etiya.customerservice.mapper.ContactInformationMapper;
import com.etiya.customerservice.repositories.ContactInformationRepository;
import com.etiya.customerservice.services.abstracts.ContactInformationService;
import com.etiya.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import io.github.emresagiroglu.kafka.events.customer.CustomerCreatedEvent;
import io.github.emresagiroglu.kafka.events.contactinformation.ContactInformationUpdatedEvent;
import org.springframework.stereotype.Service;
import com.etiya.customerservice.kafka.ContactMediumProducer;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ContactInformationServiceImpl implements ContactInformationService {
    private final CustomerService customerService;
    private final ContactInformationRepository contactInformationRepository;
    private final CustomerProducer customerProducer;
    private final ContactMediumProducer contactMediumProducer;
    public List<ListContactInformationResponseDto> getContactInformationsAll() {
        List<ContactInformation> contactInformationList = contactInformationRepository.findAll();
        return ContactInformationMapper.INSTANCE.getAllContactInformationsResponseDtoFromContactInformations(contactInformationList);
    }
    public GetContactInformationResponseDto getContactInformationById(Long id) {
        ContactInformation contactInformation = contactInformationRepository.findById(id).orElseThrow();
        return ContactInformationMapper.INSTANCE.getContactInformationResponseDtoFromContactInformation(contactInformation);
    }
    public CreateContactInformationResponseDto saveContactInformation(CreateContactInformationRequestDto contactInformationDto) {
        ContactInformation contactInformation = ContactInformationMapper.INSTANCE.createContactInformationFromCreateContactInformationRequestDto(contactInformationDto);
        contactInformationRepository.save(contactInformation);


        // Kafka için setleme işlemi
        CreateContactInformationResponseDto createContactInformationResponseDto =
                ContactInformationMapper.INSTANCE.createContactInformationResponseDtoFromContactInformation(contactInformation);

        createContactInformationResponseDto.setId(contactInformation.getId());
        createContactInformationResponseDto.setCustomerId(contactInformation.getCustomerId().getId());

        //customer id ye göre customer bulma
        GetIndividualCustomerResponseDto individualCustomer = customerService.getIndividualCustomerById(contactInformation.getCustomerId().getId());
        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
        customerCreatedEvent.setNationalityId(individualCustomer.getNationalityId());
        customerCreatedEvent.setId(individualCustomer.getId().toString());
        customerCreatedEvent.setFirstName(individualCustomer.getFirstName());
        customerCreatedEvent.setMiddleName(individualCustomer.getMiddleName());
        customerCreatedEvent.setLastName(individualCustomer.getLastName());
        customerCreatedEvent.setMobilePhone(contactInformation.getMobilePhone());
        //todo : accountnumber setlenmedi

        customerProducer.sendMessage(customerCreatedEvent);

        return createContactInformationResponseDto;
    }
    public UpdateContactInformationResponseDto updateContactInformation(UpdateContactInformationRequestDto contactInformationDto, Long id) {
        ContactInformation contactInformation = ContactInformationMapper.INSTANCE.contactInformationFromUpdateRequestDto(contactInformationDto);
        contactInformation.setId(id);
        contactInformationRepository.save(contactInformation);


        ContactInformationUpdatedEvent contactInformationUpdatedEvent = new ContactInformationUpdatedEvent();
        contactInformationUpdatedEvent.setId(contactInformation.getId().toString());
        contactInformationUpdatedEvent.setMobilePhone(contactInformation.getMobilePhone());
        contactMediumProducer.sendMessage(contactInformationUpdatedEvent);


        return ContactInformationMapper.INSTANCE.updateContactInformationResponseDtoFromContactInformation(contactInformation);
    }
    public void deleteContactInformation(Long id) {
        contactInformationRepository.deleteById(id);
    }
}
