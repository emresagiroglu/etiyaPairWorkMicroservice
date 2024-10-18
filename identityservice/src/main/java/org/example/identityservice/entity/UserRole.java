package org.example.identityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.identityservice.core.BaseEntity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_role")
public class UserRole extends BaseEntity {
    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role roleId;
}
