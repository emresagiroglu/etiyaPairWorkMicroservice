package org.example.identityservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.identityservice.dto.LoginRequestDto;
import org.example.identityservice.dto.RegisterRequestDto;
import org.example.identityservice.dto.RegisterResponseDto;
import org.example.identityservice.dto.TokenResponse;
import org.example.identityservice.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin()
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequestDto loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@Valid @RequestBody RegisterRequestDto registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}