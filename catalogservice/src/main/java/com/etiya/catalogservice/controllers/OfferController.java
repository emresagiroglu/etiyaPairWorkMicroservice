package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.dtos.offer.*;
import com.etiya.catalogservice.services.abstracts.OfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/offers")
public class OfferController {


    private final OfferService offerService;

    @PostMapping
    public ResponseEntity<CreatedOfferResponseDto> add(@Valid @RequestBody CreateOfferRequestDto createOfferRequest){
        return ResponseEntity.ok(offerService.add(createOfferRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOfferResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(offerService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListOfferResponseDto>> getAll()
    {
        return ResponseEntity.ok(offerService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedOfferResponseDto> update(@PathVariable UUID id, @RequestBody UpdateOfferRequestDto request)
    {
        return ResponseEntity.ok(offerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        offerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
