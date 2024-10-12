package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.dto.contactinformation.*;

import java.util.List;
import java.util.UUID;

public interface ContactInformationService {
    GetContactInformationResponseDto getContactInformationById(UUID id);

    List<ListContactInformationResponseDto> getContactInformationsAll();

    CreateContactInformationResponseDto saveContactInformation(CreateContactInformationRequestDto createContactInformationRequestDto);

    UpdateContactInformationResponseDto updateContactInformation(UpdateContactInformationRequestDto updateContactInformationRequestDto, UUID id);

    void deleteContactInformation(UUID id);
}
