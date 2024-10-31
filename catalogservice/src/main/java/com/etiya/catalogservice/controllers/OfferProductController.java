package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.offerProduct.*;
import com.etiya.catalogservice.services.abstracts.OfferProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/offerproducts")
public class OfferProductController {


    private final OfferProductService offerProductService;

    @PostMapping
    public ResponseEntity<CreatedOfferProductResponseDto> add(@Valid @RequestBody CreateOfferProductRequestDto createOfferProductRequest){
        return ResponseEntity.ok(offerProductService.add(createOfferProductRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOfferProductResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(offerProductService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListOfferProductResponseDto>> getAll()
    {
        return ResponseEntity.ok(offerProductService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedOfferProductResponseDto> update(@PathVariable UUID id, @RequestBody UpdateOfferProductRequestDto request)
    {
        return ResponseEntity.ok(offerProductService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        offerProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
