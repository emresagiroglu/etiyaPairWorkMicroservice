package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.contactinformation.*;

import java.util.List;


public interface ContactInformationService {
    GetContactInformationResponseDto getContactInformationById(Long id);

    List<ListContactInformationResponseDto> getContactInformationsAll();

    CreateContactInformationResponseDto saveContactInformation(CreateContactInformationRequestDto createContactInformationRequestDto);

    UpdateContactInformationResponseDto updateContactInformation(UpdateContactInformationRequestDto updateContactInformationRequestDto, Long id);

    void deleteContactInformation(Long id);
}
