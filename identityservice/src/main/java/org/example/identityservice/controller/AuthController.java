package org.example.identityservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.identityservice.dto.LoginRequestDto;
import org.example.identityservice.dto.RegisterRequestDto;
import org.example.identityservice.dto.TokenResponse;
import org.example.identityservice.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequestDto loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequestDto registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}