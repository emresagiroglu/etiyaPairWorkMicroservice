package org.example.identityservice.service.user;

import org.example.identityservice.dto.RegisterRequestDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void create(RegisterRequestDto user);
    UserDetails loadUserByUsername(String username);
}
