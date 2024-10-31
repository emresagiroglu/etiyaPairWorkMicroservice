package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.city.CityRequestDto;
import com.etiya.customerservice.dto.city.CityResponseDto;
import com.etiya.customerservice.services.abstracts.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping()
    public ResponseEntity<List<CityResponseDto>> getAll()
    {
        return ResponseEntity.ok(cityService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CityResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.getById(id));
    }
    @PostMapping
    public ResponseEntity<CityResponseDto> createCity(@Valid @RequestBody CityRequestDto cityDto)
    {
        return ResponseEntity.ok(cityService.save(cityDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CityResponseDto> updateCity(
            @PathVariable Long id,
            @RequestBody CityRequestDto cityDto)
    {
        return ResponseEntity.ok(cityService.update(cityDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id)
    {
        cityService.delete(id);
        return ResponseEntity.ok().build();
    }

}
