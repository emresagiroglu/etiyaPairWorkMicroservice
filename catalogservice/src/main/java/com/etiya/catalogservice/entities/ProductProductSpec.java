package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_productSpecs")
@Entity
public class ProductProductSpec extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "productSpec_id")
    private ProductSpec productSpec;

    //ER diagramında bu tablo yok. Konuşulduğu için eklendi!
}
