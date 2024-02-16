package com.matdialog.matdialog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Entity @Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String productDescription;
    private Double productDiscountPrice;
    private  Double productActualPrice;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "product_images",
            joinColumns = {
                 @JoinColumn(name = "product_id")
            },
            inverseJoinColumns = {
                 @JoinColumn(name = "image_id")
            }
    )
    private Set<ImageModal> productImages;

    public Set<ImageModal> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ImageModal> productImages) {
        this.productImages = productImages;
    }
}
