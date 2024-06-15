package com.example.domain.supplier;

import com.example.domain.BaseEntity;
import com.example.domain.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Supplier extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products = new HashSet<>();
}
