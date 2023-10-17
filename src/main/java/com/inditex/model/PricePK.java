package com.inditex.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Embeddable
@Data
@Accessors(chain = true)
public class PricePK implements Serializable {

    @Column(name = "PRICE_LIST")
    private Long priceList;

    @Column(name = "PRODUCT_ID")
    private Long productId; // This could be foreing key to a product table

    @Column(name = "PRIORITY")
    private Long priority;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = false, updatable = false)
    private Brand brand;
}
