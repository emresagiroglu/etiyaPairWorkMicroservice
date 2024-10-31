package org.example.searchservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.searchservice.dto.SearchResponse;
import org.example.searchservice.service.FilterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("api/search")
public class SearchCustomerController {
    private FilterService filterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SearchResponse> search(
            @RequestParam(required = false) String nationalityId,
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String mobilePhone,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String middleName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String sortField,
            @RequestParam(required = false) String sortOrder
    ) {
        return this.filterService.search(
                nationalityId, id, accountNumber, mobilePhone, firstName,middleName, lastName , sortField, sortOrder
        );
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<SearchResponse> getAll(){
        return this.filterService.getAll();
    }

}
