package com.etiya.identityservice.service.auth;


import com.etiya.identityservice.dto.LoginRequestDto;

public interface AuthService {

    String login(LoginRequestDto loginRequest);
}