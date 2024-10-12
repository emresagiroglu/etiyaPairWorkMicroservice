package com.etiya.customerservice.services.abstracts;

public interface ContactInformationService {
    GetContactInformationResponseDto getContactInformationById(UUID id);

    List<ListContactInformationResponseDto> getContactInformationsAll();

    CreateContactInformationResponseDto saveContactInformation(CreateContactInformationRequestDto createContactInformationRequestDto);

    UpdateContactInformationResponseDto updateContactInformation(UpdateContactInformationRequestDto updateContactInformationRequestDto, UUID id);

    void deleteContactInformation(UUID id);
}
