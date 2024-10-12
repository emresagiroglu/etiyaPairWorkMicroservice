package com.etiya.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/neighbourhoods")
public class NeighbourhoodController {
    private final NeighbourhoodService neighbourhoodService;

    @GetMapping()
    public ResponseEntity<List<NeighbourhoodDto>> getAll()
    {
        return ResponseEntity.ok(neighbourhoodService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<NeighbourhoodDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(neighbourhoodService.getById(id));
    }
    @PostMapping
    public ResponseEntity<NeighbourhoodDto> createNeighbourhood(@RequestBody NeighbourhoodDto neighbourhoodDto)
    {
        return ResponseEntity.ok(neighbourhoodService.save(neighbourhoodDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<NeighbourhoodDto> updateNeighbourhood(
            @PathVariable UUID id,
            @RequestBody NeighbourhoodDto neighbourhoodDto)
    {
        return ResponseEntity.ok(neighbourhoodService.update(neighbourhoodDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNeighbourhood(@PathVariable UUID id)
    {
        neighbourhoodService.delete(id);
        return ResponseEntity.ok().build();
    }
}
