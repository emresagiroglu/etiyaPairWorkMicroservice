package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "price")
    private Double price;
    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<OfferProduct> offerProducts;

    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<ProductCampaignPackage> productCampaignPackages;
    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<ProductSpec> productSpecs;
    @ToString.Exclude
    @ElementCollection
    private List<Long> orderItems;
    @ToString.Exclude
    @ElementCollection
    private List<Long> cartItems;

    //Order items ile ilişkili. Başka mikroserviste!
    //Cart item ile ilişkili başka serviste!
}
