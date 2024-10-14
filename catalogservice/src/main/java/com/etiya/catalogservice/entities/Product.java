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
@Table(name = "products")
@Entity
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OfferProduct> offerProducts;

    @OneToMany(mappedBy = "product")
    private List<ProductSpec> productSpecs;

    @OneToMany(mappedBy = "product")
    private List<ProductCampaignPackage> productCampaignPackages;

    @OneToMany(mappedBy = "products")
    private List<ProductProductSpecs> productProductSpecs;

    @ElementCollection
    private List<Long> orderItems;

    @ElementCollection
    private List<Long> cartItems;

    //Order items ile ilişkili. Başka mikroserviste!
    //Cart item ile ilişkili başka serviste!
}
