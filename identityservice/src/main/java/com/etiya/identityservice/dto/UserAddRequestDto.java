package com.etiya.identityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddRequestDto {

    private String email;
    private String password;
    private String name;
    private String surname;
    private String identityNo;

}
