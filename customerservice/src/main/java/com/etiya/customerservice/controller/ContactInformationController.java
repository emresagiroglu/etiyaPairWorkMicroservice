package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.contactinformation.*;
import com.etiya.customerservice.services.abstracts.ContactInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contactinformations")
public class ContactInformationController {
    private final ContactInformationService contactInformationService;

    @GetMapping()
    public ResponseEntity<List<ListContactInformationResponseDto>> getAll()
    {
        return ResponseEntity.ok(contactInformationService.getContactInformationsAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetContactInformationResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(contactInformationService.getContactInformationById(id));
    }
    @PostMapping
    public ResponseEntity<CreateContactInformationResponseDto> createContactInformation(@RequestBody CreateContactInformationRequestDto contactInformationDto)
    {
        return ResponseEntity.ok(contactInformationService.saveContactInformation(contactInformationDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateContactInformationResponseDto> updateContactInformation(
            @PathVariable UUID id,
            @RequestBody UpdateContactInformationRequestDto contactInformationDto)
    {
        return ResponseEntity.ok(contactInformationService.updateContactInformation(contactInformationDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactInformation(@PathVariable UUID id)
    {
        contactInformationService.deleteContactInformation(id);
        return ResponseEntity.ok().build();
    }
}
