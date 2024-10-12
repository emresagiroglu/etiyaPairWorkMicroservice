package com.etiya.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/billingaccounts")
public class BillingAccountController {
    private final BillingAccountService billingAccountService;
    @GetMapping()
    public ResponseEntity<List<BillingAccountDto>> getAll()
    {
        return ResponseEntity.ok(billingAccountService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BillingAccountDto> getById(@PathVariable UUID id){
        return ResponseEntity.ok(billingAccountService.getById(id));
    }
    @PostMapping
    public ResponseEntity<BillingAccountDto> createBillingAccount(@RequestBody BillingAccountDto billingAccountDto)
    {
        return ResponseEntity.ok(billingAccountService.save(billingAccountDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BillingAccountDto> updateBillingAccount(
            @PathVariable UUID id,
            @RequestBody BillingAccountDto billingAccountDto)
    {
        return ResponseEntity.ok(billingAccountService.update(billingAccountDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillingAccount(@PathVariable UUID id)
    {
        billingAccountService.delete(id);
        return ResponseEntity.ok().build();
    }
}
