package com.etiya.catalogservice.controllers;


import com.etiya.catalogservice.dtos.productProductSpec.*;
import com.etiya.catalogservice.services.abstracts.ProductProductSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/productProductSpecs")
public class ProductProductSpecController {

    private final ProductProductSpecService productProductSpecService;

    @PostMapping
    public ResponseEntity<CreatedProductProductSpecResponseDto> add(@RequestBody CreateProductProductSpecRequestDto createProductProductSpecRequest){
        return ResponseEntity.ok(productProductSpecService.add(createProductProductSpecRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductProductSpecResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(productProductSpecService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListProductProductSpecResponseDto>> getAll()
    {
        return ResponseEntity.ok(productProductSpecService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedProductProductSpecResponseDto> update(@PathVariable UUID id, @RequestBody UpdateProductProductSpecRequestDto request)
    {
        return ResponseEntity.ok(productProductSpecService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        productProductSpecService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
