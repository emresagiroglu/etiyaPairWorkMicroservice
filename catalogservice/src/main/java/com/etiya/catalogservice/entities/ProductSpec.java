package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_specs")
@Entity
public class ProductSpec extends BaseEntity {

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private Specification specification;

    @OneToMany(mappedBy = "product_spec")
    private List<ProductProductSpecs> productProductSpecs;

}
