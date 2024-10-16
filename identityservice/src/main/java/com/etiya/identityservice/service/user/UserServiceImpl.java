package com.etiya.identityservice.service.user;

import com.etiya.identityservice.dto.UserAddRequestDto;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("mail"));
    }

    @Override
    public void add(UserAddRequestDto request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));//TODO gerekli mi

        userRepository.save(user);
    }

}
