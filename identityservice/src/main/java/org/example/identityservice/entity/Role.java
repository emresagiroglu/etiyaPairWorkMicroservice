package org.example.identityservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.identityservice.core.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="roles")
public class Role extends BaseEntity implements GrantedAuthority
{
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "roleId")
    private List<UserRole> userRoles;


    @Override
    public String getAuthority() {
        return name;
    }
}