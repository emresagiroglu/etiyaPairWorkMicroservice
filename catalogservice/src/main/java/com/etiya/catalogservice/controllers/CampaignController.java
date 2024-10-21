package com.etiya.catalogservice.controllers;


import com.etiya.catalogservice.dtos.campaign.CreateCampaignRequestDto;
import com.etiya.catalogservice.dtos.campaign.CreatedCampaignResponseDto;
import com.etiya.catalogservice.services.abstracts.CampaignService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping
    public ResponseEntity<CreatedCampaignResponseDto> add(@RequestBody CreateCampaignRequestDto createCampaignRequest){
        return ResponseEntity.ok(campaignService.add(createCampaignRequest));
    }

    @GetMapping
    public String show(){
        return "HEEEY";
    }
}
