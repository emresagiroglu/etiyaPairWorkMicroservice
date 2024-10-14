package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.contactinformation.*;
import com.etiya.customerservice.entity.ContactInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactInformationMapper {
    ContactInformationMapper INSTANCE = Mappers.getMapper(ContactInformationMapper.class);

    @Mapping(source = "customerId" ,target = "customerId.customerId" )
    ContactInformation createContactInformationFromCreateContactInformationRequestDto(CreateContactInformationRequestDto createContactInformationRequestDto);
    @Mapping(source = "customerId.customerId" , target = "customerId")
    CreateContactInformationResponseDto createContactInformationResponseDtoFromContactInformation(ContactInformation contactInformation);
    @Mapping(source = "customerId.customerId" , target = "customerId")
    GetContactInformationResponseDto getContactInformationResponseDtoFromContactInformation(ContactInformation contactInformation);
    @Mapping(source = "customerId.customerId" , target = "customerId")
    ListContactInformationResponseDto getContactInformationsResponseDtoFromContactInformations(ContactInformation contactInformation);
    @Mapping(source = "customerId.customerId" , target = "customerId")
    List<ListContactInformationResponseDto> getAllContactInformationsResponseDtoFromContactInformations(List<ContactInformation> contactInformations);
    @Mapping(source = "customerId.customerId" , target = "customerId")
    UpdateContactInformationResponseDto updateContactInformationResponseDtoFromContactInformation(ContactInformation contactInformation);
    @Mapping(source = "customerId" ,target = "customerId.customerId" )
    ContactInformation contactInformationFromUpdateRequestDto(UpdateContactInformationRequestDto updateContactInformationRequestDto);
}
