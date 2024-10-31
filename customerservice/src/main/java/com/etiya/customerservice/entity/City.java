package com.etiya.customerservice.entity;


import io.github.emresagiroglu.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CITY")
@Entity
public class City extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "CITY_NAME")
    private String name;


    @OneToMany(mappedBy = "city_id")
    private List<District> districts;
}
