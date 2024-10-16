package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.dtos.category.*;
import com.etiya.catalogservice.services.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService campaignService;

    @PostMapping
    public ResponseEntity<CreatedCategoryResponseDto> add(@RequestBody CreateCategoryRequestDto createCategoryRequest){
        return ResponseEntity.ok(campaignService.add(createCategoryRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(campaignService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ListCategoryResponseDto>> getAll()
    {
        return ResponseEntity.ok(campaignService.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdatedCategoryResponseDto> update(@PathVariable UUID id, @RequestBody UpdateCategoryRequestDto request)
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
