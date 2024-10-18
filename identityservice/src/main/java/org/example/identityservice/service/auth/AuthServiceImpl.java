package org.example.identityservice.service.auth;
import io.github.halitkalayci.security.BaseJwtService;
import org.example.identityservice.dto.LoginRequestDto;
import org.example.identityservice.dto.RegisterRequestDto;
import org.example.identityservice.dto.TokenResponse;
import org.example.identityservice.entity.User;
import org.example.identityservice.mapper.UserMapper;
import org.example.identityservice.service.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final BaseJwtService baseJwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenResponse login(LoginRequestDto loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!passwordMatching)
            throw new RuntimeException("E-posta veya şifre hatalı.");

        return new TokenResponse(baseJwtService.generateToken(user.getUsername()),true);
    }
    @Override
    public TokenResponse register(RegisterRequestDto registerRequest) {
//        User userToAdd =new User();
//        userToAdd.setEmail(registerRequest.getEmail());
//        userToAdd.setName(registerRequest.getName());
//        userToAdd.setSurname(registerRequest.getSurname());
//        userToAdd.setIdentityNo(registerRequest.getIdentityNo());
//
//        User user = userService.create(userToAdd);
//
       // User user = UserMapper.INSTANCE.userFromUserAddRequestDto(registerRequest);

        /* register dto
            şifresini aldım encode edip kendi alanına setledim

         */


        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userService.create(registerRequest);
        return new TokenResponse(baseJwtService.generateToken(registerRequest.getEmail()), true);
    }

}
