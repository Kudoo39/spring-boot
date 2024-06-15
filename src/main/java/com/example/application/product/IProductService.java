package com.example.application.product;

import com.example.domain.product.Product;

import java.util.List;

public interface IProductService {
    public Product createOne(Product product);
    public List<Product> findAll();
}
