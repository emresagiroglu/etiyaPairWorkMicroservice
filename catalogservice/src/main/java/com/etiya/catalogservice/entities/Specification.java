package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specifications")
@Entity
public class Specification extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "data_type")
    private String dataType;

    @OneToMany(mappedBy = "specification")
    private List<ProductSpec> productSpecs;
}
