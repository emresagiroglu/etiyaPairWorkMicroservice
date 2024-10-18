package org.example.identityservice.mapper;

import org.example.identityservice.dto.RegisterRequestDto;
import org.example.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userFromUserAddRequestDto(RegisterRequestDto registerRequestDto);



}
