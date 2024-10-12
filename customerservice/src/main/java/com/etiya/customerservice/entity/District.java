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
@Table(name = "DISTRICT")
@Entity
public class District {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "DISTRICT_ID")
    private UUID id;
    @Column(name = "DISTRICT_NAME")
    private String name;


    @ManyToOne()
    @JoinColumn(name = "CITY_ID")
    private City city_id;

    @OneToMany(mappedBy = "district_id")
    @Column(name = "NEIGHBOURHOODS")
    private List<Neighbourhood> neighbourhoods;
}
