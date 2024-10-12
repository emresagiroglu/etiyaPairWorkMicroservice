package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.contactinformation.*;
import com.etiya.customerservice.entity.ContactInformation;
import com.etiya.customerservice.mapper.ContactInformationMapper;
import com.etiya.customerservice.repositories.ContactInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactInformationServiceImpl {
    private final ContactInformationRepository contactInformationRepository;

    public List<ListContactInformationResponseDto> getAll() {
        List<ContactInformation> contactInformationList = contactInformationRepository.findAll();
        return ContactInformationMapper.INSTANCE.getAllContactInformationsResponseDtoFromContactInformations(contactInformationList);
    }
    public GetContactInformationResponseDto getById(UUID id) {
        ContactInformation contactInformation = contactInformationRepository.findById(id).orElseThrow();
        return ContactInformationMapper.INSTANCE.getContactInformationResponseDtoFromContactInformation(contactInformation);
    }
    public CreateContactInformationResponseDto save(CreateContactInformationRequestDto contactInformationDto) {
        ContactInformation contactInformation = ContactInformationMapper.INSTANCE.createContactInformationFromCreateContactInformationRequestDto(contactInformationDto);
        contactInformationRepository.save(contactInformation);
        return ContactInformationMapper.INSTANCE.createContactInformationResponseDtoFromContactInformation(contactInformation);
    }
    public UpdateContactInformationResponseDto update(UpdateContactInformationRequestDto contactInformationDto, UUID id) {
        ContactInformation contactInformation = ContactInformationMapper.INSTANCE.contactInformationFromUpdateRequestDto(contactInformationDto);
        contactInformation.setId(id);
        contactInformationRepository.save(contactInformation);
        return ContactInformationMapper.INSTANCE.updateContactInformationResponseDtoFromContactInformation(contactInformation);
    }
    public void delete(UUID id) {
        contactInformationRepository.deleteById(id);
    }
}
