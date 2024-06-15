package com.example.infrastructure.product;

import com.example.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductJpaRepo extends JpaRepository<Product, UUID> {
}
