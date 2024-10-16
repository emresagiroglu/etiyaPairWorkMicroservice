package com.etiya.customerservice.entity;

import com.etiya.customerservice.core.entity.BaseEntity;
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

    @Column(name = "DISTRICT_NAME")
    private String name;


    @ManyToOne()
    @JoinColumn(name = "CITY_ID")
    private City city_id;

    @OneToMany(mappedBy = "district_id")
    private List<Neighbourhood> neighbourhoods;
}
