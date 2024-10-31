package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.campaignCustomer.*;
import com.etiya.catalogservice.services.abstracts.CampaignCustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/campaignCustomers")
public class CampaignCustomerController {


    private final CampaignCustomerService campaignCustomerService;

    @PostMapping
    public ResponseEntity<CreatedCampaignCustomerResponseDto> add(@Valid @RequestBody CreateCampaignCustomerRequestDto createCampaignCustomerRequest){
        return ResponseEntity.ok(campaignCustomerService.add(createCampaignCustomerRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCampaignCustomerResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(campaignCustomerService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListCampaignCustomerResponseDto>> getAll()
    {
        return ResponseEntity.ok(campaignCustomerService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedCampaignCustomerResponseDto> update(@PathVariable UUID id, @RequestBody UpdateCampaignCustomerRequestDto request)
    {
        return ResponseEntity.ok(campaignCustomerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        campaignCustomerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
