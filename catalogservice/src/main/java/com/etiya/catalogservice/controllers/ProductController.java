package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.product.*;
import com.etiya.catalogservice.services.abstracts.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CreatedProductResponseDto> add(@Valid @RequestBody CreateProductRequestDto createProductRequest){


        return ResponseEntity.ok(productService.add(createProductRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListProductResponseDto>> getAll()
    {
        return ResponseEntity.ok(productService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedProductResponseDto> update(@PathVariable UUID id, @RequestBody UpdateProductRequestDto request)
    {
        return ResponseEntity.ok(productService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
