package com.example.domain.product;

import com.example.domain.product.Product;

import java.util.List;

public interface IProductRepo {
    public Product createProduct(Product product);
    public List<Product> listAll();
}
