package com.example.domain.warehouse;

import com.example.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String street;
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String city;
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String postalCode;
}
