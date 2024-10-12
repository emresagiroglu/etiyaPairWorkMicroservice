package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.entity.ContactInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactInformationServiceImpl {
    private final ContactInformationRepository contactInformationRepository;

    public List<ContactInformationDto> getAll() {
        List<ContactInformation> contactInformationList = contactInformationRepository.findAll();
        return ContactInformationMapper.INSTANCE.getAllContactInformationDtoFromContactInformation(contactInformationList);
    }
    public ContactInformationDto getById(UUID id) {
        ContactInformation contactInformation = contactInformationRepository.findById(id).orElseThrow();
        return ContactInformationMapper.INSTANCE.getContactInformationDtoFromContactInformation(contactInformation);
    }
    public ContactInformationDto save(ContactInformationDto contactInformationDto) {
        ContactInformation contactInformation = ContactInformationMapper.INSTANCE.getContactInformationFromContactInformationDto(contactInformationDto);
        contactInformationRepository.save(contactInformation);
        return ContactInformationMapper.INSTANCE.getContactInformationDtoFromContactInformation(contactInformation);
    }
    public ContactInformationDto update(ContactInformationDto contactInformationDto, UUID id) {
        ContactInformation contactInformation = ContactInformationMapper.INSTANCE.getContactInformationFromContactInformationDto(contactInformationDto);
        contactInformation.setId(id);
        contactInformationRepository.save(contactInformation);
        return ContactInformationMapper.INSTANCE.getContactInformationDtoFromContactInformation(contactInformation);
    }
    public void delete(UUID id) {
        contactInformationRepository.deleteById(id);
    }
}
