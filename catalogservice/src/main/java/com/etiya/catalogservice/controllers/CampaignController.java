package com.etiya.catalogservice.controllers;


import com.etiya.catalogservice.dtos.campaign.CreateCampaignRequestDto;
import com.etiya.catalogservice.dtos.campaign.CreatedCampaignResponseDto;
import com.etiya.catalogservice.dtos.campaign.*;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping
    public ResponseEntity<CreatedCampaignResponseDto> add(@Valid @RequestBody CreateCampaignRequestDto createCampaignRequest){
        return ResponseEntity.ok(campaignService.add(createCampaignRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCampaignResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(campaignService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListCampaignResponseDto>> getAll()
    {
        return ResponseEntity.ok(campaignService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedCampaignResponseDto> update(@PathVariable UUID id, @RequestBody UpdateCampaignRequestDto request)
    {
        return ResponseEntity.ok(campaignService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        campaignService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
