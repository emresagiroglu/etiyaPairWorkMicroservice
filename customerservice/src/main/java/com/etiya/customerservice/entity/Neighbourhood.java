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
@Table(name = "NEIGHBOURHOOD")
@Entity
public class Neighbourhood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "NEIGHBOURHOOD_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_ID")
    private District district_id;

    @OneToMany(mappedBy = "neighbourhoodId")
    private List<Address> addresses;

}
