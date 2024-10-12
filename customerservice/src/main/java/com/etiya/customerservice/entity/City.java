package com.etiya.customerservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CITY")
@Entity
public class City {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "CITY_ID")
    private UUID id;
    @Column(name = "CITY_NAME")
    private String name;


    @OneToMany(mappedBy = "city_id")
    @Column(name = "Districts")
    private List<District> districts;
}
