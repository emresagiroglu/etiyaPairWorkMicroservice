package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.disctrict.*;
import com.etiya.customerservice.entity.District;
import com.etiya.customerservice.services.abstracts.DistrictService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/districts")
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping()
    public ResponseEntity<List<ListDistrictResponseDto>> getAll()
    {
        return ResponseEntity.ok(districtService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetDistrictResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(districtService.getById(id));
    }
    @PostMapping
    public ResponseEntity<CreateDistrictResponseDto> createDistrict(@Valid @RequestBody CreateDistrictRequestDto createDistrictRequestDto)
    {
        return ResponseEntity.ok(districtService.save(createDistrictRequestDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateDistrictResponseDto> updateDistrict(
            @PathVariable Long id,
            @RequestBody UpdateDistrictRequestDto updateDistrictRequestDto)
    {
        return ResponseEntity.ok(districtService.update(updateDistrictRequestDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id)
    {
        districtService.delete(id);
        return ResponseEntity.ok().build();
    }
}
