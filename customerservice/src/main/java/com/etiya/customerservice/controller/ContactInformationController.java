package com.etiya.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contactinformations")
public class ContactInformationController {
    private final ContactInformationService contactInformationService;

    @GetMapping()
    public ResponseEntity<List<ContactInformationDto>> getAll()
    {
        return ResponseEntity.ok(contactInformationService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactInformationDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(contactInformationService.getById(id));
    }
    @PostMapping
    public ResponseEntity<ContactInformationDto> createContactInformation(@RequestBody ContactInformationDto contactInformationDto)
    {
        return ResponseEntity.ok(contactInformationService.save(contactInformationDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContactInformationDto> updateContactInformation(
            @PathVariable UUID id,
            @RequestBody ContactInformationDto contactInformationDto)
    {
        return ResponseEntity.ok(contactInformationService.update(contactInformationDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactInformation(@PathVariable UUID id)
    {
        contactInformationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
