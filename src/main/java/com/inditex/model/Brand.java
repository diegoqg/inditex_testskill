package com.inditex.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "BRANDS")
@Data
@Accessors(chain = true)
public class Brand {

    @Id
    @Column(name = "BRAND_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}
