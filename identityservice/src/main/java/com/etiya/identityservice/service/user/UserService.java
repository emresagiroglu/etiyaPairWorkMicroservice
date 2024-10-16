package com.etiya.identityservice.service.user;

import com.etiya.identityservice.dto.UserAddRequestDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(UserAddRequestDto request);

}