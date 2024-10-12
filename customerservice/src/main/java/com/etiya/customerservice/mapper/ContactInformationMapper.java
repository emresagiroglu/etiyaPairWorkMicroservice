package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.contactinformation.*;
import com.etiya.customerservice.entity.ContactInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactInformationMapper {
    ContactInformationMapper INSTANCE = Mappers.getMapper(ContactInformationMapper.class);

    ContactInformation createContactInformationFromCreateContactInformationRequestDto(CreateContactInformationRequestDto createContactInformationRequestDto);
    CreateContactInformationResponseDto createContactInformationResponseDtoFromContactInformation(ContactInformation contactInformation);
    GetContactInformationResponseDto getContactInformationResponseDtoFromContactInformation(ContactInformation contactInformation);
    List<ListContactInformationResponseDto> getAllContactInformationsResponseDtoFromContactInformations(List<ContactInformation> contactInformations);
    UpdateContactInformationResponseDto updateContactInformationResponseDtoFromContactInformation(ContactInformation contactInformation);
    ContactInformation contactInformationFromUpdateRequestDto(UpdateContactInformationRequestDto updateContactInformationRequestDto);
}
