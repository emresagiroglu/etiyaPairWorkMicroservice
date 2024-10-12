package com.etiya.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/districts")
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping()
    public ResponseEntity<List<DistrictDto>> getAll()
    {
        return ResponseEntity.ok(districtService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DistrictDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(districtService.getById(id));
    }
    @PostMapping
    public ResponseEntity<DistrictDto> createDistrict(@RequestBody DistrictDto districtDto)
    {
        return ResponseEntity.ok(districtService.save(districtDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DistrictDto> updateDistrict(
            @PathVariable UUID id,
            @RequestBody DistrictDto districtDto)
    {
        return ResponseEntity.ok(districtService.update(districtDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable UUID id)
    {
        districtService.delete(id);
        return ResponseEntity.ok().build();
    }
}
