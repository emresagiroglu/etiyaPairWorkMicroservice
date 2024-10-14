package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.dto.contactinformation.*;
import com.etiya.customerservice.entity.ContactInformation;
import com.etiya.customerservice.mapper.ContactInformationMapper;
import com.etiya.customerservice.repositories.ContactInformationRepository;
import com.etiya.customerservice.services.abstracts.ContactInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ContactInformationServiceImpl implements ContactInformationService {
    private final ContactInformationRepository contactInformationRepository;

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
        return ContactInformationMapper.INSTANCE.createContactInformationResponseDtoFromContactInformation(contactInformation);
    }
    public UpdateContactInformationResponseDto updateContactInformation(UpdateContactInformationRequestDto contactInformationDto, Long id) {
        ContactInformation contactInformation = ContactInformationMapper.INSTANCE.contactInformationFromUpdateRequestDto(contactInformationDto);
        contactInformation.setId(id);
        contactInformationRepository.save(contactInformation);
        return ContactInformationMapper.INSTANCE.updateContactInformationResponseDtoFromContactInformation(contactInformation);
    }
    public void deleteContactInformation(Long id) {
        contactInformationRepository.deleteById(id);
    }
}
