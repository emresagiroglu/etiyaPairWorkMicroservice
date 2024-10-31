package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.productSpec.*;
import com.etiya.catalogservice.services.abstracts.ProductSpecService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/productSpecs")
public class ProductSpecController {


    private final ProductSpecService productSpecService;

    @PostMapping
    public ResponseEntity<CreatedProductSpecResponseDto> add(@Valid @RequestBody CreateProductSpecRequestDto createProductSpecRequest){
        return ResponseEntity.ok(productSpecService.add(createProductSpecRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductSpecResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(productSpecService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListProductSpecResponseDto>> getAll()
    {
        return ResponseEntity.ok(productSpecService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedProductSpecResponseDto> update(@PathVariable UUID id, @RequestBody UpdateProductSpecRequestDto request)
    {
        return ResponseEntity.ok(productSpecService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        productSpecService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
