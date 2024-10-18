package org.example.identityservice.service.auth;

import org.example.identityservice.dto.LoginRequestDto;
import org.example.identityservice.dto.RegisterRequestDto;
import org.example.identityservice.dto.TokenResponse;

public interface AuthService {
    TokenResponse login(LoginRequestDto loginRequest);

    TokenResponse register(RegisterRequestDto registerRequest);
}
