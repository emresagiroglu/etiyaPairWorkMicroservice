package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.dtos.specification.*;
import com.etiya.catalogservice.services.abstracts.SpecificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/specifications")
public class SpecificationController {


    private final SpecificationService specificationService;

    @PostMapping
    public ResponseEntity<CreatedSpecificationResponseDto> add(@Valid @RequestBody CreateSpecificationRequestDto createSpecificationRequest){
        return ResponseEntity.ok(specificationService.add(createSpecificationRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSpecificationResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(specificationService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListSpecificationResponseDto>> getAll()
    {
        return ResponseEntity.ok(specificationService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedSpecificationResponseDto> update(@PathVariable UUID id, @RequestBody UpdateSpecificationRequestDto request)
    {
        return ResponseEntity.ok(specificationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        specificationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
