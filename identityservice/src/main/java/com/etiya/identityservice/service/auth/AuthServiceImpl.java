package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.configuration.BaseJwtService;
import com.etiya.identityservice.dto.LoginRequestDto;
import com.etiya.identityservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final BaseJwtService baseJwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginRequestDto loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!passwordMatching)
            throw new RuntimeException("E-posta veya şifre hatalı.");

        return baseJwtService.generateToken(user.getUsername());
    }


}