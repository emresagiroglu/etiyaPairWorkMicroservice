package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.disctrict.UpdateDistrictRequestDto;
import com.etiya.customerservice.dto.neighbourhood.*;
import com.etiya.customerservice.services.abstracts.NeighbourhoodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/neighbourhoods")
public class NeighbourhoodController {
    private final NeighbourhoodService neighbourhoodService;

    @GetMapping()
    public ResponseEntity<List<ListNeighbourhoodResponseDto>> getAll()
    {
        return ResponseEntity.ok(neighbourhoodService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetNeighbourhoodResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(neighbourhoodService.getById(id));
    }
    @PostMapping
    public ResponseEntity<CreateNeighbourhoodResponseDto> createNeighbourhood(@RequestBody @Valid CreateNeighbourhoodRequestDto createNeighbourhoodRequestDto)
    {
        return ResponseEntity.ok(neighbourhoodService.save(createNeighbourhoodRequestDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateNeighbourhoodResponseDto> updateNeighbourhood(
            @PathVariable Long id,
            @RequestBody UpdateNeighbourhoodRequestDto updateNeighbourhoodRequestDto)
    {
        return ResponseEntity.ok(neighbourhoodService.update(updateNeighbourhoodRequestDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNeighbourhood(@PathVariable Long id)
    {
        neighbourhoodService.delete(id);
        return ResponseEntity.ok().build();
    }
}
