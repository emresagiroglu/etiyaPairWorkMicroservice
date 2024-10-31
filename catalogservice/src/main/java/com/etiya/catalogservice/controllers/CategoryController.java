package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.services.abstracts.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CreatedCategoryResponseDto> add(@Valid @RequestBody CreateCategoryRequestDto createCategoryRequest){
        return ResponseEntity.ok(categoryService.add(createCategoryRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListCategoryResponseDto>> getAll()
    {
        return ResponseEntity.ok(categoryService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedCategoryResponseDto> update(@PathVariable UUID id, @RequestBody UpdateCategoryRequestDto request)
    {
        return ResponseEntity.ok(categoryService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id)
    {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
