package org.example.identityservice.service.user;

import lombok.RequiredArgsConstructor;
import org.example.identityservice.dto.RegisterRequestDto;
import org.example.identityservice.entity.User;
import org.example.identityservice.mapper.UserMapper;
import org.example.identityservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("mail"));
    }

    @Override
    public void create(RegisterRequestDto request) {
        // todo: mapper
       User user = UserMapper.INSTANCE.userFromUserAddRequestDto(request);
       userRepository.save(user);
    }
}
