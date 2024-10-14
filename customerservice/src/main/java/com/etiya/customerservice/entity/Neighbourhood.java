package com.etiya.customerservice.entity;

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
public class Neighbourhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEIGHBOURHOOD_ID")
    private Long id;

    @Column(name = "NEIGHBOURHOOD_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_ID")
    private District district_id;

    @OneToMany(mappedBy = "neighbourhoodId")
    private List<Address> addresses;

}
