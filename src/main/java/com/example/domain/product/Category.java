package com.example.domain.product;

import com.example.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Category extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;
}
