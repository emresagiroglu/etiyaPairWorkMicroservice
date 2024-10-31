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
@Table(name = "DISTRICT")
@Entity
public class District extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "DISTRICT_NAME")
    private String name;


    @ManyToOne()
    @JoinColumn(name = "CITY_ID")
    private City city_id;

    @OneToMany(mappedBy = "district_id")
    private List<Neighbourhood> neighbourhoods;
}
