package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.disctrict.UpdateDistrictRequestDto;
import com.etiya.customerservice.dto.neighbourhood.*;
import com.etiya.customerservice.services.abstracts.NeighbourhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/neighbourhoods")
public class NeighbourhoodController {
    private final NeighbourhoodService neighbourhoodService;

    @GetMapping()
    public ResponseEntity<List<ListNeighbourhoodResponseDto>> getAll()
    {
        return ResponseEntity.ok(neighbourhoodService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetNeighbourhoodResponseDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(neighbourhoodService.getById(id));
    }
    @PostMapping
    public ResponseEntity<CreateNeighbourhoodResponseDto> createNeighbourhood(@RequestBody CreateNeighbourhoodRequestDto createNeighbourhoodRequestDto)
    {
        return ResponseEntity.ok(neighbourhoodService.save(createNeighbourhoodRequestDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateNeighbourhoodResponseDto> updateNeighbourhood(
            @PathVariable UUID id,
            @RequestBody UpdateNeighbourhoodRequestDto updateNeighbourhoodRequestDto)
    {
        return ResponseEntity.ok(neighbourhoodService.update(updateNeighbourhoodRequestDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNeighbourhood(@PathVariable UUID id)
    {
        neighbourhoodService.delete(id);
        return ResponseEntity.ok().build();
    }
}
