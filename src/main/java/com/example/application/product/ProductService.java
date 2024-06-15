package com.example.application.product;

import com.example.domain.product.Product;
import com.example.infrastructure.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo _productRepo;

    @Override
    public Product createOne(Product product) {
        return _productRepo.createProduct(product);
    }

    @Override
    public List<Product> findAll() {
        return _productRepo.listAll();
    }
}
