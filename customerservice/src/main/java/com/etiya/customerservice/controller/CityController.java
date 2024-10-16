package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.city.CityDto;
import com.etiya.customerservice.services.abstracts.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping()
    public ResponseEntity<List<CityDto>> getAll()
    {
        return ResponseEntity.ok(cityService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.getById(id));
    }
    @PostMapping
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto)
    {
        return ResponseEntity.ok(cityService.save(cityDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CityDto> updateCity(
            @PathVariable Long id,
            @RequestBody CityDto cityDto)
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