package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.billingaccount.*;
import com.etiya.customerservice.services.abstracts.BillingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers/billingaccounts")
public class BillingAccountController {
    private final BillingAccountService billingAccountService;
    @GetMapping()
    public ResponseEntity<List<ListBillingAccountResponseDto>> getAll()
    {
        return ResponseEntity.ok(billingAccountService.getBillingAccountsAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetBillingAccountResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(billingAccountService.getBillingAccountById(id));
    }
    @PostMapping
    public ResponseEntity<CreateBillingAccountResponseDto> createBillingAccount(@RequestBody CreateBillingAccountRequestDto billingAccountDto)
    {
        return ResponseEntity.ok(billingAccountService.saveBillingAccount(billingAccountDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateBillingAccountResponseDto> updateBillingAccount(
            @PathVariable Long id,
            @RequestBody UpdateBillingAccountRequestDto billingAccountDto)
    {
        return ResponseEntity.ok(billingAccountService.updateBillingAccount(billingAccountDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillingAccount(@PathVariable Long id)
    {
        billingAccountService.deleteBillingAccount(id);
        return ResponseEntity.ok().build();
    }
}
