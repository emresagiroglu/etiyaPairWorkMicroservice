package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.productCampaignPackage.*;
import com.etiya.catalogservice.services.abstracts.ProductCampaignPackageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/productCampaignPackages")
public class ProductCampaignPackageController {


    private final ProductCampaignPackageService productCampaignPackageService;

    @PostMapping
    public ResponseEntity<CreatedProductCampaignPackageResponseDto> add(@Valid @RequestBody CreateProductCampaignPackageRequestDto createProductCampaignPackageRequest){
        return ResponseEntity.ok(productCampaignPackageService.add(createProductCampaignPackageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductCampaignPackageResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(productCampaignPackageService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListProductCampaignPackageResponseDto>> getAll()
    {
        return ResponseEntity.ok(productCampaignPackageService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedProductCampaignPackageResponseDto> update(@PathVariable UUID id, @RequestBody UpdateProductCampaignPackageRequestDto request)
    {
        return ResponseEntity.ok(productCampaignPackageService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        productCampaignPackageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
